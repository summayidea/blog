package com.ghy.blog.back.service;

import com.ghy.blog.back.bean.Article;
import com.ghy.blog.back.bean.Category;
import com.ghy.blog.back.bean.Tag;
//import com.ghy.blog.back.bean.Tag;

import java.util.List;
public interface  ArticleService {
    List<Article> list(String uid, String title);
    void isOpen(Article article);
    List<Category> queryCategory();
    List<Tag> queryTags(String cid);
    Article saveOrUpdate(Article article);
    Article queryById(String id);
    void deleteById(String id);
}
