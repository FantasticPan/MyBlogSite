package com.pan.blog.dao.mapper;

import com.pan.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by FantasticPan on 2019/1/3.
 */
@Mapper
public interface BlogMapper {

    List<Blog> getRecentArticles();
    Blog getFirstArticleByReadSize();
    Blog getSecondArticleByReadSize();
    Blog getThirdArticleByReadSize();
}
