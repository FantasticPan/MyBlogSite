package com.pan.blog.dao.mapper;

import com.pan.blog.entity.Tag;
import com.pan.blog.entity.TagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {
    int countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);
}