package com.imnu.controller;

import com.imnu.bean.User;
import com.imnu.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:14
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        User loginUser = userService.login(user);
        if (loginUser != null){
            // 登录成功
            session.setAttribute("user",loginUser);
            return "/user/index";
        }
        return "login";
    }

}
