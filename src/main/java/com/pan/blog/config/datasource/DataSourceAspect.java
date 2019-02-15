package com.pan.blog.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面类
 * 将注解放在service实现类的方法前，自动设置当前数据源为注解中数据源
 * Created by FantasticPan on 2019/2/15.
 */
@Slf4j
@Aspect
@Component
@Order(5)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {

    @Pointcut("execution(* com.pan.blog.service.impl..*.*(..))")
    public void aspect() {
    }

    /**
     * 配置前置处理,使用在方法aspect()上注册的切入点，绑定数据源信息
     */
    @Before("aspect()")
    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String methodName = point.getSignature().getName();
        log.info("pointMethod:" + methodName);
        Class<?> clazz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(DataSource.class)) {
                DataSource data = method.getAnnotation(DataSource.class);
                log.info("value:" + data.value());
                //设置数据源
                DynamicDataSourceHolder.setDataSource(data.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置后置处理，清空数据源信息
     *
     * @param point
     */
    @After("aspect()")
    public void after(JoinPoint point) {
        DynamicDataSourceHolder.clearDataSource();
    }
}
