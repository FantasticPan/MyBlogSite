package com.pan.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pan.blog.entity.Blog;
import com.pan.blog.entity.SiteInfo;
import com.pan.blog.entity.Tag;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.RedisService;
import com.pan.blog.service.SiteInfoService;
import com.pan.blog.service.TagService;
import com.pan.blog.util.ResultUtil;
import com.pan.blog.util.SiteInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by FantasticPan on 2018/12/1.
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private SiteInfoService siteInfoService;
    @Autowired
    private RedisService redisService;

    @Value("${blog.profile.initial-date}")
    private String initialDate;
    @Value("${blog.profile.session-time}")
    private int sessionTime;
    private static final String BLOG = "blog";
    private static final String BLOG_LIST = "blogList";
    private static final String CATALOG_LIST = "catalogList";
    private static final String TAGS_LIST = "tagsList";
    private static final String SITE_INFO = "siteInfo";
    private static final String RECENT_ARTICLES = "recentArticles";

    @RequestMapping("/")
    public ModelAndView index(Model model,
                              HttpServletRequest request) {

        log.info("进入主页函数");

        //通过session统计访问量，在session存在期间重复刷新界面访问量不增加，可扩展通过ip统计
        String sessionId = "index";
        LocalDateTime time = (LocalDateTime) request.getSession().getAttribute(sessionId);
        if (time == null) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(sessionTime); //设置session过期时间，单位：秒
            session.setAttribute(sessionId, LocalDateTime.now());
            siteInfoService.visitSizeIncrease();
        }

        List<Tag> tags = tagService.findAllTags();
        Set<String> tagsList = new HashSet<>();

        List<String> catalogs = blogService.findCatalog();
        Set<String> catalogList = new HashSet<>();

        try {
            SiteInfoUtil.initialSiteInfo(blogService, tagService, siteInfoService, initialDate, tags, tagsList, catalogs, catalogList);
        } catch (ParseException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }

        List<SiteInfo> siteInfo = siteInfoService.findAll();

        //缓存操作
        List<Blog> blogList;
        if (redisService.hasKey(BLOG_LIST)) {
            log.info("redis");
            blogList = JSONArray.parseArray(redisService.get(BLOG_LIST).toString(), Blog.class);
        } else {
            log.info("sql");
            blogList = blogService.getAllBlog();
            redisService.set(BLOG_LIST, JSON.toJSONString(blogList));
            System.out.println(JSON.toJSONString(blogList));
        }
        List<Blog> recentArticles = blogService.getRecentArticles();

        model.addAttribute("blogList", blogList);
        model.addAttribute("catalogs", catalogList);
        model.addAttribute("tags", tagsList);
        model.addAttribute("info", siteInfo.get(0));
        model.addAttribute("recentArticles", recentArticles);

        return ResultUtil.view("index", "blogModel", model);
    }

    @RequestMapping("/403")
    public ModelAndView page403() {
        return ResultUtil.view("403");
    }

    @GetMapping("/login")
    public ModelAndView loginHtml() {
        return ResultUtil.view("login");
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        return ResultUtil.view("register");
    }

    @RequestMapping("/tag")
    public ModelAndView tag() {
        return ResultUtil.view("tag-catalog");
    }
}
