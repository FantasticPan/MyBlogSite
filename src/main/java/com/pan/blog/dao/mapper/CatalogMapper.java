package com.pan.blog.dao.mapper;

import com.pan.blog.entity.Catalog;
import com.pan.blog.entity.CatalogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogMapper {
    int countByExample(CatalogExample example);

    int deleteByExample(CatalogExample example);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    List<Catalog> selectByExample(CatalogExample example);

    int updateByExampleSelective(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByExample(@Param("record") Catalog record, @Param("example") CatalogExample example);
}