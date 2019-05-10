/**
 * File generated at: 2017年10月29日下午11:43:18
 */
package com.company.project.bean;

/**
 * 用户信息线程上下文
 *
 * @author chenyin
 */
public class UserContext {
    private static final ThreadLocal<LoginUser> USER_THREAD_LOCAL = new ThreadLocal<LoginUser>();

    public static LoginUser getUser() {
        return USER_THREAD_LOCAL.get();
    }

    public static void setUser(LoginUser user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static void clean() {
        USER_THREAD_LOCAL.remove();
    }
}
