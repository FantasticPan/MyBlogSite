package com.pan.blog;

import com.pan.blog.entity.Blog;
import com.pan.blog.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBlogSiteApplicationTests {

    //@Autowired
    //private BlogMapper blogMapper;
    @Autowired
    private BlogService blogService;

	@Test
	public void contextLoads() {

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //System.out.println(passwordEncoder.encode("111"));
        //System.out.println(blogMapper.getRecentArticles());
        Blog blog = new Blog();
        blog.setContent("hhh");
        blog.setHtmlContent("ggg");
        blog.setTitle("ddd");
        blog.setSummary("kkk");
        blog.setCatalog("hhh");
        blog.setCategory("hhh");
        blog.setCreateTime(new Date());
        blogService.saveBlog(blog);
        throw new RuntimeException();
	}

}

