package com.pan.blog.service.impl;

import com.pan.blog.dao.BlogRepository;
import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Tag;
import com.pan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {

        return blogRepository.save(blog);
    }

    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Long blogNum() {
        return blogRepository.count();
    }

    @Override
    public List<Blog> findBlogsByTag(Tag tag) {
        return blogRepository.findBlogsByTags(tag);
    }

    @Override
    public List<Blog> findBlogByCatalog(String catalog) {
        return blogRepository.findBlogsByCatalog(catalog);
    }

    @Override
    public List<String> findCatalog() {
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
        blog.setVoteSize(blog.getVoteSize()+1);
        this.saveBlog(blog);
    }

    @Override
    public Integer getVoteSize(Long id) {
        return this.getBlogById(id).getVoteSize();
    }
}
