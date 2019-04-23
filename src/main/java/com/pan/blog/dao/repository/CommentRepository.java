package com.pan.blog.dao.repository;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by FantasticPan on 2019/4/23.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBlog(Blog blog);
}
