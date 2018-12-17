package com.pan.blog.util;

import com.pan.blog.entity.SiteInfo;
import com.pan.blog.entity.Tag;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.SiteInfoService;
import com.pan.blog.service.TagService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by FantasticPan on 2018/12/9.
 */
public class SiteInfoUtil {

    public static void initialSiteInfo(BlogService blogService,
                                       TagService tagService,
                                       SiteInfoService siteInfoService,
                                       String initialDate,
                                       List<Tag> tags,
                                       Set<String> tagsList,
                                       List<String> catalogs,
                                       Set<String> catalogList) throws ParseException {

        //标签
        for (Tag tag : tags) {
            tagsList.add(tag.getTagName());
        }

        //分类
        catalogList.addAll(catalogs);

        //文章数
        Long blogNum = blogService.blogNum();

        //运行天数
        int runDays = DateUtil.dateBetweenIncludeToday(DateUtil.dateParse(initialDate, null), new Date());

        List<SiteInfo> infoList = siteInfoService.findAll();
        if (infoList.isEmpty()) {
            siteInfoService.saveSiteInfo(new SiteInfo(blogNum, tagsList.size(), catalogList.size(), runDays, 0L));
        } else {
            SiteInfo siteInfo = infoList.get(0);
            siteInfo.setArticleNum(blogService.blogNum());
            siteInfo.setTagNum(tagsList.size());
            siteInfo.setCatalogNum(catalogList.size());
            siteInfo.setRunDays(runDays);
            siteInfoService.saveSiteInfo(siteInfo);
        }
    }
}
