package com.imnu.service;

import com.imnu.bean.User;

/**
 * @author WenWangXin
 * @create 2022-06-24-20:15
 */
public interface UserService {

    /**
     * 登录
     * @param user user
     * @return user
     */
    User login(User user);
}
