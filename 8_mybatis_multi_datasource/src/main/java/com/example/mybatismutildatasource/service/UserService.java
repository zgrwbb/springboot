package com.example.mybatismutildatasource.service;

import com.example.mybatismutildatasource.domain.master.User;

/**
 * 用户业务层接口
 *
 * @author wangbobo
 */
public interface UserService {
    /**
     * 根据用户名搜索用户
     *
     * @param userName userName
     * @return User {@link User}
     */
    User getUserByName(String userName);
}
