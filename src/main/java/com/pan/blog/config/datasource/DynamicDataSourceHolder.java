package com.pan.blog.config.datasource;

/**
 * 用ThreadLcoal管理当前数据源
 * Created by FantasticPan on 2019/2/15.
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<DynamicDataSourceGlobal> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据库类型
     *
     * @param dbType
     */
    public static void setDataSource(DynamicDataSourceGlobal dbType) {
        if (dbType == null)
            throw new NullPointerException();
        contextHolder.set(dbType);
    }

    /**
     * 获取数据库类型
     *
     * @return
     */
    public static DynamicDataSourceGlobal getDataSource() {
        return contextHolder.get();
    }

    /**
     * 清除数据库类型
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }
}
