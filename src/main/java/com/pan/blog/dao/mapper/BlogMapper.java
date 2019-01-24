package com.pan.blog.dao.mapper;

import com.pan.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //可以不用添加注解，不过在IDEA中使用@Autowire注入的时候会有红线错误，不影响项目运行
public interface BlogMapper {

    List<Blog> getRecentArticles();

    Blog getFirstArticleByReadSize();

    Blog getSecondArticleByReadSize();

    Blog getThirdArticleByReadSize();
}