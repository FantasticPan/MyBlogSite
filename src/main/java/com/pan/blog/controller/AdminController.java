package com.pan.blog.controller;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.SiteInfo;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.SiteInfoService;
import com.pan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by FantasticPan on 2018/12/6.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private SiteInfoService siteInfoService;

    @RequestMapping("")
    public ModelAndView index(Model model) {
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogList", blogList);
        return ResultUtil.view("admin/index", "blogModel", model);
    }

    /**
     * 接受ajax请求，获取所有文章
     *
     * @return
     */
    @GetMapping("/getAllArticle")
    @ResponseBody
    public List<Blog> getAllArticle() {
        return blogService.getAllBlog();
    }

    @GetMapping("/getSiteInfo")
    @ResponseBody
    public SiteInfo getSiteInfo() {
        return siteInfoService.findAll().get(0);
    }
}
