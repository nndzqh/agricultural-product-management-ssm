package com.imnu.service.impl;

import com.imnu.bean.User;
import com.imnu.mapper.UserMapper;
import com.imnu.service.UserService;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:11
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
