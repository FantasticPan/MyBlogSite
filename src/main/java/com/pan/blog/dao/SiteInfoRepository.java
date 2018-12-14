package com.pan.blog.dao;

import com.pan.blog.entity.SiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
public interface SiteInfoRepository extends JpaRepository<SiteInfo, Long> {

    @Override
    List<SiteInfo> findAll();
}
