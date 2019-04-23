package com.pan.blog.service.impl;

import com.pan.blog.dao.repository.CommentRepository;
import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Comment;
import com.pan.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by FantasticPan on 2019/4/23.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAllCommentByBlog(Blog blog) {
        return commentRepository.findByBlog(blog);
    }
}
