package com.ghy.blog.back.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table(name = "t_article")
@NameStyle(Style.normal)
public class Article {
    @Id
    private String aid;//主键
    private String title;//标题
    private String digest;//文章摘要
    private String content;//具体内容
    private String cid;//文章所属标签(栏目)
    private String visit_count;//访问量
    private String create_time;//创建时间
    private String update_time;//更新时间
    private String is_hot;//是否热门
    private String logo;//文章logo
    private String uid;//发布者外键
    private String isOpen;//是否公开
    private String thumbsUp;//文章的点赞数
    private String tagNames;//标签名称
    private String isCommented;//是否被评论

}
