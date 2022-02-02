package com.ghy.blog;

import com.ghy.blog.base.exception.BlogEnum;
import com.ghy.blog.base.exception.BlogException;
import org.junit.Test;

public class TestBlog {
    @Test
    public void test05(){
        int a=0;
        try {
            if(a==0){
                throw new BlogException(BlogEnum.USER_LOGIN_CODE);
            }
        }catch (BlogException e){
            System.out.println(e.getMessage());
        }

    }
}
