package com.company.project.biz.service.impl;

import com.company.project.biz.entity.User;
import com.company.project.biz.mapper.UserMapper;
import com.company.project.biz.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenyin
 * @since 2019-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
