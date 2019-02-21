package com.pan.blog.service.impl;

import com.pan.blog.dao.mapper.BlogMapper;
import com.pan.blog.dao.repository.BlogRepository;
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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by FantasticPan on 2018/11/25.
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogMapper blogMapper;

    //@DataSource(DynamicDataSourceGlobal.write)
    @Transactional
    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    //@DataSource(DynamicDataSourceGlobal.write)
    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.getOne(id);
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public List<Blog> getAllBlog() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return blogRepository.findAll(sort);
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public Long blogNum() {
        return blogRepository.count();
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public List<Blog> findBlogsByTag(Tag tag) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return blogRepository.findBlogsByTags(tag, sort);
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public List<Blog> findBlogByCatalog(String catalog) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return blogRepository.findBlogsByCatalog(catalog, sort);
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public List<String> findCatalog() {
        return blogRepository.findCatalog();
    }

    //@DataSource(DynamicDataSourceGlobal.write)
    @Override
    public void readSizeIncrease(Long id) {
        Blog blog = this.getBlogById(id);
        //cas操作加1
        AtomicInteger readSize = new AtomicInteger(blog.getReadSize());
        blog.setReadSize(readSize.incrementAndGet());
        //this.saveBlog(blog); //使用此写法事务失效，因为此处的this指的是被代理的真实对象BlogServiceImpl的实例，不是BlogService代理对象自身
        ((BlogService) AopContext.currentProxy()).saveBlog(blog);
    }

    //@DataSource(DynamicDataSourceGlobal.write)
    @Override
    public void voteSizeInIncrease(Long id) {
        Blog blog = this.getBlogById(id);
        AtomicInteger voteSize = new AtomicInteger(blog.getVoteSize());
        blog.setVoteSize(voteSize.incrementAndGet());
        ((BlogService) AopContext.currentProxy()).saveBlog(blog);
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public Integer getVoteSize(Long id) {
        return ((BlogService) AopContext.currentProxy()).getBlogById(id).getVoteSize();
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public List<Blog> getRecentArticles() {
        return blogMapper.getRecentArticles();
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public Blog getFirstArticleByReadSize() {
        return blogMapper.getFirstArticleByReadSize();
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public Blog getSecondArticleByReadSize() {
        return blogMapper.getSecondArticleByReadSize();
    }

    //@DataSource(DynamicDataSourceGlobal.read)
    @Override
    public Blog getThirdArticleByReadSize() {
        return blogMapper.getThirdArticleByReadSize();
    }
}
