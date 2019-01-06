package com.pan.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true) //通过aop框架暴露代理对象，aopContext能够访问，配合事务AopContext.currentProxy()使用
@MapperScan("com.pan.blog.dao.mapper")
@EnableJpaRepositories("com.pan.blog.dao.repository") //指明JPA的dao接口所在的位置，和mybatis混合使用有时会出现bean注入异常，需要单独指明
public class MyBlogSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogSiteApplication.class, args);
	}

}

