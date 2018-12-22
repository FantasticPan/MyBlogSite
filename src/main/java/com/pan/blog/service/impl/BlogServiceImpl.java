package com.pan.blog.service.impl;

import com.pan.blog.dao.BlogRepository;
import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Tag;
import com.pan.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
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
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return blogRepository.findAll(sort);
    }

    @Override
    public Long blogNum() {
        return blogRepository.count();
    }

    @Override
    public List<Blog> findBlogsByTag(Tag tag) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return blogRepository.findBlogsByTags(tag, sort);
    }

    @Override
    public List<Blog> findBlogByCatalog(String catalog) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return blogRepository.findBlogsByCatalog(catalog, sort);
    }

    @Override
    public List<String> findCatalog() {
        return blogRepository.findCatalog();
    }

    @Override
    public void readSizeIncrease(Long id) {
        Blog blog = this.getBlogById(id);
        blog.setReadSize(blog.getReadSize() + 1);
        //this.saveBlog(blog); //使用此写法事务失效，因为此处的this指向的对象不是spring代理的对象
        ((BlogService) AopContext.currentProxy()).saveBlog(blog);
    }

    @Override
    public void voteSizeInIncrease(Long id) {
        Blog blog = this.getBlogById(id);
        blog.setVoteSize(blog.getVoteSize() + 1);
        ((BlogService) AopContext.currentProxy()).saveBlog(blog);
    }

    @Override
    public Integer getVoteSize(Long id) {
        return ((BlogService) AopContext.currentProxy()).getBlogById(id).getVoteSize();
    }
}
