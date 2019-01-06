package com.pan.blog.dao.mapper;

import com.pan.blog.entity.BlogTag;
import com.pan.blog.entity.BlogTagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogTagMapper {
    int countByExample(BlogTagExample example);

    int deleteByExample(BlogTagExample example);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    List<BlogTag> selectByExample(BlogTagExample example);

    int updateByExampleSelective(@Param("record") BlogTag record, @Param("example") BlogTagExample example);

    int updateByExample(@Param("record") BlogTag record, @Param("example") BlogTagExample example);
}