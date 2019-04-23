package com.pan.blog.controller;

import com.pan.blog.entity.Comment;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by FantasticPan on 2019/4/23.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public List<Comment> get(@PathVariable("id") Long id) {

        List<Comment> comments = commentService.findAllCommentByBlog(blogService.getBlogById(id));
        for (Comment comment : comments) {
            System.out.println(comment.toString());
        }
        return commentService.findAllCommentByBlog(blogService.getBlogById(id));
    }
}
