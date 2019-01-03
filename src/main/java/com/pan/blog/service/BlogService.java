package com.pan.blog.service;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Tag;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
public interface BlogService {

    void saveBlog(Blog blog);

    void deleteBlog(Long id);

    /**
     * 根据id获取博客
     *
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    List<Blog> getAllBlog();

    Long blogNum();

    List<Blog> findBlogsByTag(Tag tag);

    List<Blog> findBlogByCatalog(String catalog);

    List<String> findCatalog();

    void readSizeIncrease(Long id);

    void voteSizeInIncrease(Long id);

    Integer getVoteSize(Long id);

    List<Blog> getRecentArticles();

    Blog getFirstArticleByReadSize();

    Blog getSecondArticleByReadSize();

    Blog getThirdArticleByReadSize();
}
