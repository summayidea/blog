package com.ghy.blog.base.exception;

public enum BlogEnum {
    //第一个001:用户登录模块，第二个001：登录中验证码错误情况
    USER_LOGIN_CODE("001-001","验证码输入错误"),
    USER_LOGIN_ACCOUNT("001-002","用户名或密码输入错误"),
    USER_VERIFY_PASS("001-003","输入的旧密码错误"),
    USER_UPDATE("001-004","输入的旧密码错误"),
    ARTICLE_ISOPEN("002-001","修改文章是否公开失败"),
    ARTICLE_PUNISH("002-002","发布文章失败"),
    ARTICLE_UPDATE("002-003","修改文章失败"),
    ARTICLE_DELETE("002-004","删除文章失败");

    private String typeCode;//属于哪个模块下的操作失败code
    private String message;//具体错误消息


    BlogEnum(String typeCode, String message) {
        this.typeCode = typeCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
