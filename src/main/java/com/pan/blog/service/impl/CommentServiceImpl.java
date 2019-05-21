package com.pan.blog.service.impl;

import com.pan.blog.dao.repository.CommentRepository;
import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Comment;
import com.pan.blog.service.CommentService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Transactional
    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void commentVoteSizeIncrease(Long id) {
        Comment comment = commentRepository.getOne(id);
        AtomicInteger voteSize = new AtomicInteger(comment.getVoteSize());
        comment.setVoteSize(voteSize.incrementAndGet());
        ((CommentService) AopContext.currentProxy()).saveComment(comment);
    }

    @Override
    public void commentStepSizeIncrease(Long id) {
        Comment comment = commentRepository.getOne(id);
        AtomicInteger stepSize = new AtomicInteger(comment.getStepSize());
        comment.setVoteSize(stepSize.incrementAndGet());
        ((CommentService) AopContext.currentProxy()).saveComment(comment);
    }
}
