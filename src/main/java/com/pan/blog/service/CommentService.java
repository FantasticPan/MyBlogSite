package com.pan.blog.service;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Comment;

import java.util.List;

/**
 * Created by FantasticPan on 2019/4/23.
 */
public interface CommentService {

    List<Comment> findAllCommentByBlog(Blog blog);

    void saveComment(Comment comment);
}
