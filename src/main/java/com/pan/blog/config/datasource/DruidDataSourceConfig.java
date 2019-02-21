package com.pan.blog.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by FantasticPan on 2018/12/15.
 */
@Configuration
@Slf4j
public class DruidDataSourceConfig {

    // 获取yml配置文件中的配置信息
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.druid.filters}")
    private String filters;
    @Value("${spring.datasource.druid.connection-properties}")
    private String connectProperties;
    @Value("${spring.datasource.druid.initial-size}")
    private Integer initialSize;
    @Value("${spring.datasource.druid.min-idle}")
    private Integer minIdle;
    @Value("${spring.datasource.druid.max-active}")
    private Integer maxActive;
    @Value("${spring.datasource.druid.max-wait}")
    private Integer maxWait;
    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;
    @Value("${spring.datasource.druid.test-while-idle}")
    private Boolean testWhileIdle;
    @Value("${spring.datasource.druid.test-on-borrow}")
    private Boolean testOnBorrow;
    @Value("${spring.datasource.druid.test-on-return}")
    private Boolean testOnReturn;
    @Value("${spring.datasource.druid.pool-prepared-statements}")
    private Boolean poolPreparedStatements;

    /**
     * 由于SpringBoot和Druid兼容性问题，手动配置连接池
     */
    @Bean
    @Primary // 不能保证只有一个实例，@Primary注解的实例优先于其他实例被注入
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driver);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setConnectionProperties(connectProperties);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("druid filters error:" + e);
        }
        return datasource;
    }

    //Master-Salve配置-------------------------------------------------------------------------------------------

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DruidDataSource primaryDataSource() {
////      return DataSourceBuilder.create().build();
//        log.info("master");
//        return new DruidDataSource();
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public Object secondDataSource() {
////      return DataSourceBuilder.create().build();
//        log.info("slave");
//        return new DruidDataSource();
//    }
//
//    @Primary
//    @Bean("dataSource")
//    public DynamicDataSource dynamicDataSource() {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//
//        dynamicDataSource.setWriteDataSource(primaryDataSource());
//        List<Object> dataSources = new ArrayList<>();
//        dataSources.add(secondDataSource());
//        dynamicDataSource.setReadDataSources(dataSources);
//        dynamicDataSource.setReadDataSourcePollPattern(1);
//
//        //配置默认数据源
//        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource());
//
//        //配置多数据源
//        //Map<Object, Object> objectMap = new HashMap<>();
//        //objectMap.put("writeDataSource", primaryDataSource());
//        //objectMap.put("readDataSources", secondDataSource());
//        //dynamicDataSource.setTargetDataSources(objectMap);
//        return dynamicDataSource;
//    }

    /**
     * 监控页面 ip + 端口/druid/index.htm
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "李攀");
        servletRegistrationBean.addInitParameter("loginPassword", "lp19970622");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "true");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 配置@Transactional注解事务
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        //return new DataSourceTransactionManager(dynamicDataSource());
        return new DataSourceTransactionManager(dataSource());
    }
}
