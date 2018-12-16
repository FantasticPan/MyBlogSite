package com.pan.blog.service.impl;

import com.pan.blog.dao.BlogRepository;
import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Tag;
import com.pan.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "blog") //为缓存注解指定cacheNames，注解可重定义
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    @Override
    @CacheEvict(value = "blogs", allEntries = true)
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
        log.info("进入saveBlog方法");
    }

    @Transactional
    @Override
    @CacheEvict(allEntries = true)
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<Blog> getAllBlog() {
        log.info("进入getAllBlog方法");
        return blogRepository.findAll();
    }

    @Override
    public Long blogNum() {
        return blogRepository.count();
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<Blog> findBlogsByTag(Tag tag) {
        log.info("findBlogsByTag");
        return blogRepository.findBlogsByTags(tag);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<Blog> findBlogByCatalog(String catalog) {
        log.info("findBlogByCatalog");
        return blogRepository.findBlogsByCatalog(catalog);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<String> findCatalog() {
        log.info("findCatalog");
        return blogRepository.findCatalog();
    }

    @Override
    public void readSizeIncrease(Long id) {
        Blog blog = this.getBlogById(id);
        blog.setReadSize(blog.getReadSize() + 1);
        this.saveBlog(blog);
    }

    @Override
    public void voteSizeInIncrease(Long id) {
        Blog blog = this.getBlogById(id);
        blog.setVoteSize(blog.getVoteSize() + 1);
        this.saveBlog(blog);
    }

    @Override
    public Integer getVoteSize(Long id) {
        return this.getBlogById(id).getVoteSize();
    }
}
