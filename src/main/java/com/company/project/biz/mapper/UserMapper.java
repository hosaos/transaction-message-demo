package com.company.project.biz.mapper;

import com.company.project.biz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenyin
 * @since 2019-05-10
 */
public interface UserMapper extends BaseMapper<User> {
    int reduceMoney(@Param("userId") Long userId, @Param("money") Long money);

}
