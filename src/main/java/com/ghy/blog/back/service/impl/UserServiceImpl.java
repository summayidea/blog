package com.ghy.blog.back.service.impl;

import com.ghy.blog.back.bean.User;
import com.ghy.blog.back.mapper.UserMapper;
import com.ghy.blog.back.service.UserService;
import com.ghy.blog.base.exception.BlogEnum;
import com.ghy.blog.base.exception.BlogException;
import com.ghy.blog.base.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user, String code,String rightCode) {
        //校验验证码
        if(!rightCode.equals(code)){
            throw new BlogException(BlogEnum.USER_LOGIN_CODE);
        }

        //把用户输入的密码进行加密
        String password = user.getPassword();
        password = MD5Util.getMD5(password);
        user.setPassword(password);
        //校验用户名和密码是否正确
        List<User> users = userMapper.select(user);
        if(users.size() == 0){
            throw new BlogException(BlogEnum.USER_LOGIN_ACCOUNT);
        }

        return users.get(0);
    }
    @Override
    public void verifyOldPwd(String oldPwd, User user) {
        oldPwd = MD5Util.getMD5(oldPwd);
        String password = user.getPassword();
        if(!password.equals(oldPwd)){
            throw new BlogException(BlogEnum.USER_VERIFY_PASS);
        }
    }
    @Override
    public void updateUser(User user) {
        //给用户输入的新密码加密
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        //count:影响记录数
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count == 0){
            throw new BlogException(BlogEnum.USER_UPDATE);
        }
    }
}

