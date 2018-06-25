package com.example.pagingsorting.web;

import com.example.pagingsorting.domain.User;
import com.example.pagingsorting.service.UserService;
import com.example.pagingsorting.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController 控制类
 *
 * @author wangbobo
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** 获取page<User>
     * @param pageable pageable
     * @return Page<User>
     */
    @RequestMapping(method = RequestMethod.GET)
    public Page<User> getUserByPage(Pageable pageable) {
        logger.info("\n分页获取用户信息: "+"\nPageNumber: "+pageable.getPageNumber()+"\nPageSize : "+pageable.getPageSize());
        return userService.findByPage(pageable);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
        logger.info("\n 新增用户: " + user);
        return userService.saveUserByUser(user).toString();
    }
}
