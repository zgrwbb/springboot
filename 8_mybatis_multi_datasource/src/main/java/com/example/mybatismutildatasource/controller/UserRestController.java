package com.example.mybatismutildatasource.controller;

import com.example.mybatismutildatasource.domain.master.User;
import com.example.mybatismutildatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @author wangbobo
 * @date 2018/7/6 17:40
 */
@RestController
@RequestMapping(value = "/user/")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getUserByName")
    public User getUserByName(String userName) {
        return userService.getUserByName(userName);
    }
}
