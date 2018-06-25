package com.example.pagingsorting.service.impl;

import com.example.pagingsorting.domain.User;
import com.example.pagingsorting.domain.UserRepository;
import com.example.pagingsorting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl 类
 * @author wangbobo
 * @date 2018/6/25 11:37
 */
@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User saveUserByUser(User user) {
        userRepository.save(user);
        return user;
    }
}
