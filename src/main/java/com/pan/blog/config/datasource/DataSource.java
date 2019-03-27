package com.pan.blog.config.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解，用注解的形式实现AOP管理数据源
 * Created by FantasticPan on 2019/2/15.
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    DynamicDataSourceGlobal value() default DynamicDataSourceGlobal.read;
}
