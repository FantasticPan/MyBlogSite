package com.pan.blog.dao;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findBlogsByCatalog(String catalog, Sort sort);

    List<Blog> findBlogsByTags(Tag tag, Sort sort);

    @Query("select catalog from Blog b")
    List<String> findCatalog();
}
