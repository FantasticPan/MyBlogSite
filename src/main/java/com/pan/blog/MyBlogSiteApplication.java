package com.pan.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true) //暴露代理对象，配和事务AopContext.currentProxy()使用
public class MyBlogSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogSiteApplication.class, args);
	}

}

