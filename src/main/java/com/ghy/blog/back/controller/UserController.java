package com.ghy.blog.back.controller;

import com.ghy.blog.back.bean.User;
import com.ghy.blog.back.service.UserService;
import com.ghy.blog.base.bean.ResultVo;
import com.ghy.blog.base.exception.BlogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/back/user/login")
    @ResponseBody
    public ResultVo login(User user, String code, HttpSession session){
        ResultVo resultVo = new ResultVo();
        //从session获取正确的验证码
        String rightCode = (String) session.getAttribute("code");

        try{
            user = userService.login(user, code, rightCode);
            resultVo.setOk(true);
            //把登录用户放到session中
            session.setAttribute("user",user);
        }catch (BlogException e){
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }

    //用户登录成功后跳转到后台首页
    @RequestMapping("/workbench/index")
    public String index(){
        return "workbench/index";
    }

    //登出功能

    @RequestMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        //清除session中的用户
        session.removeAttribute("user");
        //重定向到登录页面
        return "redirect:/login.jsp";
    }

    //异步校验用户输入的原始密码是否正确
    @RequestMapping("/user/verifyOldPwd")
    @ResponseBody
    public ResultVo verifyOldPwd(String oldPwd,HttpSession session){
        ResultVo resultVo = new ResultVo();
        try{
            //获取当前登录用户
            User user = (User) session.getAttribute("user");
            userService.verifyOldPwd(oldPwd,user);
            resultVo.setOk(true);
        }catch (BlogException e){
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }

    //异步修改用户信息
    @RequestMapping("/user/updateUser")
    @ResponseBody
    public ResultVo updateUser(User user){
        ResultVo resultVo = new ResultVo();
        try{
            userService.updateUser(user);
            resultVo.setOk(true);
            resultVo.setMess("修改用户信息成功");
        }catch (BlogException e){
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }
}
