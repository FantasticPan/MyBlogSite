package com.pan.blog.dao.mapper;

import com.pan.blog.entity.UserAuthority;
import com.pan.blog.entity.UserAuthorityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthorityMapper {
    int countByExample(UserAuthorityExample example);

    int deleteByExample(UserAuthorityExample example);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    List<UserAuthority> selectByExample(UserAuthorityExample example);

    int updateByExampleSelective(@Param("record") UserAuthority record, @Param("example") UserAuthorityExample example);

    int updateByExample(@Param("record") UserAuthority record, @Param("example") UserAuthorityExample example);
}