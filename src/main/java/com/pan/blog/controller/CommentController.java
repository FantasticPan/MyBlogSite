package com.pan.blog.controller;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Comment;
import com.pan.blog.entity.User;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.CommentService;
import com.pan.blog.service.UserService;
import com.pan.blog.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by FantasticPan on 2019/4/23.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public List<Comment> getComments(@PathVariable("id") Long id) {
        Blog blog = blogService.getBlogById(id);
        return commentService.findAllCommentByBlog(blog);
    }

    @PostMapping("/comment/{id}")
    //@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void comment(@PathVariable("id") Long id,
                        @RequestParam("content") String comment_comment) {
        String username = SecurityUtil.getCurrentUsername();
        User user = userService.findByUsername(username);
        Blog blog = blogService.getBlogById(id);
        Comment comment = new Comment(comment_comment, new Date(), blog, user);
        commentService.saveComment(comment);
    }
}
