package com.pan.blog.service;

import com.pan.blog.entity.SiteInfo;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
public interface SiteInfoService {

    void saveSiteInfo(SiteInfo siteInfo);

    List<SiteInfo> findAll();

    void visitSizeIncrease();
}
