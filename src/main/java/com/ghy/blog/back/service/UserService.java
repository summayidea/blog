package com.ghy.blog.back.service;
import com.ghy.blog.back.bean.User;
public interface UserService {
    User login(User user,String code,String rightCode);
    void verifyOldPwd(String oldPwd,User user);
    void updateUser(User user);
}
