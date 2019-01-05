package com.pan.blog.dao.repository;

import com.pan.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAll();

    List<Tag> findTagsByTagName(String tagName);

    Tag findTagByTagName(String tagName);

    @Override
    void delete(Tag tag);
}
