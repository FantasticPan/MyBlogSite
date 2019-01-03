package com.pan.blog.dao;

import com.pan.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by FantasticPan on 2019/1/3.
 */
@Repository
public interface BlogMapper {

    List<Blog> getRecentArticles();
    Blog getFirstArticleByReadSize();
    Blog getSecondArticleByReadSize();
    Blog getThirdArticleByReadSize();
}
