package com.company.project.core;

/**
 * 项目常量
 */
public final class ProjectConstant {
    /**
     *  项目基础包名称，根据自己公司的项目修改
     */
    public static final String BASE_PACKAGE = "com.company.project";
    /**
     * 业务包名
     */
    public static final String BIZ_PACKAGE = BASE_PACKAGE+".biz";

    /**
     * entity实体包路径
     */
    public static final String ENTITY_PACKAGE = BIZ_PACKAGE+".entity";

    /**
     * token过期时间 8小时
     */
    public static int TOKEN_TIMEOUT = 8 * 60 * 60;

}
