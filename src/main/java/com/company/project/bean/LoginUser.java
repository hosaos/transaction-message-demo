package com.company.project.bean;

import lombok.Data;

/**
 * @author: chenyin
 * @date: 2019-03-09 15:19
 */
@Data
public class LoginUser {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 头像图片url
     */
    private String headImg;


}
