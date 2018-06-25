package com.example.pagingsorting.service;

import com.example.pagingsorting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * UserService 接口
 * @author wangbobo
 * @date 2018/6/25 11:30
 */
public interface UserService {
    /**
     * 获取用户分页列表
     * @param pageable pageable
     * @return Page<User>
     */
    Page<User> findByPage(Pageable pageable);

    /**
     * 保存用户
     * @param user user
     * @return User {@link User}
     */
    User saveUserByUser(User user);
}
