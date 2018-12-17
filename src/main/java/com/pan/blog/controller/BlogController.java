package com.pan.blog.controller;

import com.pan.blog.entity.Blog;
import com.pan.blog.entity.SiteInfo;
import com.pan.blog.entity.Tag;
import com.pan.blog.entity.User;
import com.pan.blog.service.BlogService;
import com.pan.blog.service.SiteInfoService;
import com.pan.blog.service.TagService;
import com.pan.blog.util.DateUtil;
import com.pan.blog.util.ResultUtil;
import com.pan.blog.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by FantasticPan on 2018/12/3.
 */
@Controller
@Slf4j
public class BlogController {

    //使用@Slf4j注解可以不写这句，直接使用log.**打印日志
    //private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;
    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TagService tagService;
    @Autowired
    private SiteInfoService siteInfoService;

    @GetMapping({"/{username}/blog/edit"})
    @PreAuthorize("authentication.name.equals(#username)")
    public ModelAndView getBlogEditPage(@PathVariable("username") String username, Model model) {
        User user = (User) userDetailsService.loadUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("blog", new Blog(null, null, null, null, null, null));

        return ResultUtil.view("blog-edit", "blogModel", model);
    }

    @GetMapping({"/{username}/blog/edit/{id}"})
    @PreAuthorize("authentication.name.equals(#username)")
    public ModelAndView getBlogModifyPage(@PathVariable("username") String username,
                                          @PathVariable("id") Long id,
                                          Model model) {

        User user = (User) userDetailsService.loadUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("blog", blogService.getBlogById(id));

        return ResultUtil.view("blog-edit", "blogModel", model);
    }

    @GetMapping("/blog/{id}")
    public ModelAndView showBlog(@PathVariable("id") Long id,
                                 Model model,
                                 HttpServletRequest request) {

        //通过session统计博客阅读量，在session存在期间重复刷新界面访问量不增加，可扩展通过ip统计
        String sessionId = "blogRead" + String.valueOf(id);
        LocalDateTime time = (LocalDateTime) request.getSession().getAttribute(sessionId);
        if (time == null) {
            //配置session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10 * 60);
            session.setAttribute(sessionId, LocalDateTime.now());
            blogService.readSizeIncrease(id);
        }

        List<SiteInfo> siteInfo = siteInfoService.findAll();
        Blog blog = blogService.getBlogById(id);

        //在前端显示的某一的标签
        Set<Tag> blogTags = blog.getTags();

        //在前端显示的所有的标签
        List<Tag> tags = tagService.findAllTags();
        Set<String> tagsList = new HashSet<>();
        for (Tag tag : tags) {
            tagsList.add(tag.getTagName());
        }

        //分类
        List<String> catalogs = blogService.findCatalog();
        Set<String> catalogList = new HashSet<>(catalogs);

        model.addAttribute("blog", blog);
        model.addAttribute("tags", tagsList);
        model.addAttribute("blogTags", blogTags);
        model.addAttribute("info", siteInfo.get(0));
        model.addAttribute("catalogs", catalogList);

        return ResultUtil.view("article", "blogModel", model);
    }

    /**
     * 通过分类获取博客列表
     *
     * @param catalog
     * @param model
     * @return
     */
    @GetMapping("/catalog/{catalog}")
    public ModelAndView showBlogByCatalog(@PathVariable("catalog") String catalog,
                                          Model model) {

        List<SiteInfo> siteInfo = siteInfoService.findAll();
        List<Blog> blogList = blogService.findBlogByCatalog(catalog);
        List<Tag> tags = tagService.findAllTags();

        //标签
        Set<String> tagsList = new HashSet<>();
        for (Tag tag : tags) {
            tagsList.add(tag.getTagName());
        }

        //分类
        List<String> catalogs = blogService.findCatalog();
        Set<String> catalogList = new HashSet<>(catalogs);

        model.addAttribute("tags", tagsList);
        model.addAttribute("info", siteInfo.get(0));
        model.addAttribute("type", "博客分类");
        model.addAttribute("blogList", blogList);
        model.addAttribute("name", catalog);
        model.addAttribute("catalogs", catalogList);

        return ResultUtil.view("show-catalog-type", "blogModel", model);
    }

    /**
     * 通过标签获取博客列表
     *
     * @param tagName
     * @param model
     * @return
     */
    @GetMapping("/tag/{tag}")
    public ModelAndView showBlogByTag(@PathVariable("tag") String tagName,
                                      Model model) {

        List<SiteInfo> siteInfo = siteInfoService.findAll();
        Tag tag = tagService.findTagByTagName(tagName);
        List<Blog> blogList = blogService.findBlogsByTag(tag);

        List<Tag> tags = tagService.findAllTags();

        //去除重复的标签
        Set<String> tagsList = new HashSet<>();
        for (Tag tag2 : tags) {
            tagsList.add(tag2.getTagName());
        }

        //分类
        List<String> catalogs = blogService.findCatalog();
        Set<String> catalogList = new HashSet<>(catalogs);

        model.addAttribute("tags", tagsList);
        model.addAttribute("info", siteInfo.get(0));
        model.addAttribute("type", "博客标签");
        model.addAttribute("blogList", blogList);
        model.addAttribute("name", tagName);
        model.addAttribute("catalogs", catalogList);

        return ResultUtil.view("show-catalog-type", "blogModel", model);
    }

    /**
     * 删除博客
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public void deleteBlog(@PathVariable("id") Long id) {
        blogService.deleteBlog(id);
    }

    @PostMapping("/publishBlog")
    public ModelAndView publishBlog(@RequestParam("id") Long id,
                                    @RequestParam("title") String title,
                                    @RequestParam("summary") String summary,
                                    @RequestParam("content-editormd-markdown-doc") String content,
                                    @RequestParam("content-editormd-html-code") String htmlContent,
                                    HttpServletRequest request,
                                    Model model) {

        Blog blog;
        List<String> tags = new ArrayList<>();

        if (id == null) {
            blog = new Blog();
            blog.setTitle(title);
            blog.setSummary(summary);
            blog.setContent(content);
            blog.setHtmlContent(htmlContent);
            request.getSession().setAttribute("blog", blog);

            model.addAttribute("tags", "");
        } else {
            blog = blogService.getBlogById(id);
            blog.setTitle(title);
            blog.setSummary(summary);
            blog.setContent(content);
            blog.setHtmlContent(htmlContent);
            request.getSession().setAttribute("blog", blog);

            for (Tag tag : blog.getTags()) {
                tags.add(tag.getTagName());
            }
            model.addAttribute("tags", StringUtils.join(tags, ","));
        }

        return ResultUtil.view("tag-catalog", "blogModel", model);
    }

    @PostMapping("/submit")
    public ModelAndView submitBlog(@RequestParam(value = "tags", defaultValue = "学习") String tags,
                                   @RequestParam("catalog") String catalog,
                                   @RequestParam("category") String category,
                                   @RequestParam(value = "image", defaultValue = "") String image,
                                   HttpServletRequest request) {

        Blog blog = (Blog) request.getSession().getAttribute("blog");
        Set<Tag> tagList = new HashSet<>();
        User user = (User) userDetailsService.loadUserByUsername(SecurityUtil.getCurrentUsername());
        request.getSession().removeAttribute("blog");

        //博客判断，存在更新，不存在保存
        if (blog.getId() == null) {

            //进行标签的判断，已存在同名标签，标签表不变，不存在更新标签表
            Tag tag;
            for (String s : tags.split(",")) {
                Tag tags1 = tagService.findTagByTagName(s);
                if (tags1 == null) {
                    tagService.saveTag(tag = new Tag(s));
                    tagList.add(tag);
                } else {
                    tagList.add(tags1);
                }
            }

            blog.setUser(user);
            blog.setCreateTime(DateUtil.dateTimeToDateString(new Date()));
            blog.setTags(tagList);
            blog.setCatalog(catalog);
            blog.setCategory(category);
            blog.setImage(image);
            blogService.saveBlog(blog);

            for (Tag tag1 : tagService.findAllTags()) {
                if (blogService.findBlogsByTag(tag1).isEmpty()) {
                    tagService.deleteTag(tag1);
                }
            }
        } else {
            Tag tag;
            Blog originBlog = blogService.getBlogById(blog.getId());

            for (String s : tags.split(",")) {
                Tag tags1 = tagService.findTagByTagName(s);
                if (tags1 == null) {
                    tagService.saveTag(tag = new Tag(s));
                    tagList.add(tag);
                } else {
                    tagList.add(tags1);
                }
            }

            originBlog.setTags(tagList);
            originBlog.setCatalog(catalog);
            originBlog.setCategory(category);
            originBlog.setImage(image);
            originBlog.setTitle(blog.getTitle());
            originBlog.setSummary(blog.getSummary());
            originBlog.setContent(blog.getContent());
            originBlog.setHtmlContent(blog.getHtmlContent());
            blogService.saveBlog(originBlog);

            for (Tag tag1 : tagService.findAllTags()) {
                if (blogService.findBlogsByTag(tag1).isEmpty()) {
                    tagService.deleteTag(tag1);
                }
            }
        }

        return ResultUtil.redirect("/");
    }

    /**
     * 响应js的ajax点赞请求，返回点赞后的点赞量
     *
     * @param username
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{username}/submitVote/{id}")
    @ResponseBody
    public Integer submitVote(@PathVariable("username") String username,
                              @PathVariable("id") Long id,
                              HttpServletRequest request,
                              Model model) {


        //通过session统计博客点赞量，在session存在期间重复刷新界面访问量不增加，可扩展通过ip统计
        String sessionId = "voteSize" + String.valueOf(id);
        LocalDateTime time = (LocalDateTime) request.getSession().getAttribute(sessionId);
        if (time == null) {
            //配置session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10 * 60);
            session.setAttribute(sessionId, LocalDateTime.now());
            blogService.voteSizeInIncrease(id);
        }

        return blogService.getVoteSize(id);
    }

    /**
     * 响应js的ajax点赞数量请求，在页面加载时请求一次
     *
     * @param id
     * @return
     */
    @GetMapping("/vote/{id}")
    @ResponseBody
    public Integer getVoteSize(@PathVariable("id") Long id) {
        return blogService.getVoteSize(id);
    }
}
