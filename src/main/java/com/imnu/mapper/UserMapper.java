package com.imnu.mapper;

import com.imnu.bean.User;

/**
* @author 63547
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2022-06-24 20:12:56
* @Entity com.imnu.bean.User
*/
public interface UserMapper {

    /**
     * 登录
     * @param user user
     * @return user
     */
    User login(User user);
}
