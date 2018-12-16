package com.pan.blog.service.impl;

import com.pan.blog.dao.SiteInfoRepository;
import com.pan.blog.entity.SiteInfo;
import com.pan.blog.service.SiteInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FantasticPan on 2018/11/25.
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "siteInfo")
public class SiteInfoServiceImpl implements SiteInfoService {

    @Autowired
    private SiteInfoRepository siteInfoRepository;

    @Transactional
    @Override
    @CacheEvict(allEntries = true)
    public void saveSiteInfo(SiteInfo siteInfo) {
        log.info("保存网站信息saveSiteInfo方法");
        siteInfoRepository.save(siteInfo);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<SiteInfo> findAll() {
        log.info("获取网站信息findAll方法");
        return siteInfoRepository.findAll();
    }

    @Override
    public void visitSizeIncrease() {
        List<SiteInfo> siteInfoList = this.findAll();
        SiteInfo siteInfo = siteInfoList.get(0);
        siteInfo.setVisitSize(siteInfo.getVisitSize() + 1);
        this.saveSiteInfo(siteInfo);
    }
}
