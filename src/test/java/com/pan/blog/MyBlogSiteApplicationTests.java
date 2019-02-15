package com.pan.blog;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MyBlogSiteApplicationTests {

    //@Autowired
    //private BlogMapper blogMapper;

	@Test
	public void contextLoads() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("111"));
        //System.out.println(blogMapper.getRecentArticles());
	}

}

