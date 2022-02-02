package com.ghy.blog.base.bean;

import lombok.Data;

//给客户端返回消息的Bean对象
@Data
public class ResultVo<T> {
    private String mess;//给客户端的消息
    private boolean isOk;//用户操作是否成功
    private T t;//返回对象数据
}
