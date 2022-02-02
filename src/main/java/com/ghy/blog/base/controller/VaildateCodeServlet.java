package com.ghy.blog.base.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class VaildateCodeServlet {
    @GetMapping("/code")
    public String code(HttpSession session){
        //定义图行验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(140,35,4,4);
        //把正确的验证码保存在session中
        String code = captcha.getCode();
        session.setAttribute("code",code);
        //返回验证码字符串
        return code;
    }
}
