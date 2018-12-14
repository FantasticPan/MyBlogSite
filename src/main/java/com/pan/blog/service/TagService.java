package com.pan.blog.service;

import com.pan.blog.entity.Tag;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
public interface TagService {

    Tag saveTag(Tag tag);

    List<Tag> findAllTags();

    Tag findTagByTagName(String tagName);

    void deleteTag(Tag tag);
}
