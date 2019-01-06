package com.pan.blog.dao.mapper;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.BlogExample;
import com.pan.blog.entity.BlogWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //可以不用添加注解，不过在IDEA中使用@Autowire注入的时候会有红线错误，不影响项目运行
public interface BlogMapper {
    int countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int insert(BlogWithBLOBs record);

    int insertSelective(BlogWithBLOBs record);

    List<BlogWithBLOBs> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    int updateByExampleSelective(@Param("record") BlogWithBLOBs record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogWithBLOBs record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    List<Blog> getRecentArticles();

    Blog getFirstArticleByReadSize();

    Blog getSecondArticleByReadSize();

    Blog getThirdArticleByReadSize();
}