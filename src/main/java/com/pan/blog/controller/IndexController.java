package com.pan.blog.controller;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.SiteInfo;
import com.pan.blog.entity.Tag;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.SiteInfoService;
import com.pan.blog.service.TagService;
import com.pan.blog.util.ResultUtils;
import com.pan.blog.util.SiteInfoUtils;
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
    @Value("${blog.profile.initial-date}")
    private String initialDate;

    @RequestMapping("/")
    public ModelAndView index(Model model,
                              HttpServletRequest request) {

        //通过session统计访问量，在session存在期间重复刷新界面访问量不增加，可扩展通过ip统计
        String sessionId = "index";
        LocalDateTime time = (LocalDateTime) request.getSession().getAttribute(sessionId);
        if (time == null) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10 * 60); //设置session过期时间，单位：秒，这里我设为十分钟
            session.setAttribute(sessionId, LocalDateTime.now());
            siteInfoService.visitSizeIncrease();
        }

        List<Tag> tags = tagService.findAllTags();
        Set<String> tagsList = new HashSet<>();

        List<String> catalogs = blogService.findCatalog();
        Set<String> catalogList = new HashSet<>();

        try {
            SiteInfoUtils.initialSiteInfo(blogService, tagService, siteInfoService, initialDate, tags, tagsList, catalogs, catalogList);
        } catch (ParseException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }

        List<SiteInfo> siteInfo = siteInfoService.findAll();

        List<Blog> blogList = blogService.getAllBlog();

        model.addAttribute("blogList", blogList);
        model.addAttribute("catalogs", catalogList);
        model.addAttribute("tags", tagsList);
        model.addAttribute("info", siteInfo.get(0));

        return ResultUtils.view("index", "blogModel", model);
    }

    @RequestMapping("/403")
    public ModelAndView page403() {
        return ResultUtils.view("403");
    }

    @GetMapping("/login")
    public ModelAndView loginHtml() {
        return ResultUtils.view("login");
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        return ResultUtils.view("register");
    }

    @RequestMapping("/tag")
    public ModelAndView tag() {
        return ResultUtils.view("tag-catalog");
    }
}
