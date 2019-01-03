package com.pan.blog;

import com.pan.blog.dao.BlogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBlogSiteApplicationTests {

    @Autowired
    private BlogMapper blogMapper;

	@Test
	public void contextLoads() {

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //System.out.println(passwordEncoder.encode("lp19970622"));;
        System.out.println(blogMapper.getRecentArticles());
	}

}

