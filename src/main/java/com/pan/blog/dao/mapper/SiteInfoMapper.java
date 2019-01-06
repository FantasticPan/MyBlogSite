package com.pan.blog.dao.mapper;

import com.pan.blog.entity.SiteInfo;
import com.pan.blog.entity.SiteInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteInfoMapper {
    int countByExample(SiteInfoExample example);

    int deleteByExample(SiteInfoExample example);

    int insert(SiteInfo record);

    int insertSelective(SiteInfo record);

    List<SiteInfo> selectByExample(SiteInfoExample example);

    int updateByExampleSelective(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    int updateByExample(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);
}