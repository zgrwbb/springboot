package com.example.validate.serveice;

import com.example.validate.domain.User;
import com.example.validate.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user业务层实现
 *
 * @author wangbobo
 * @date 2018/6/19 20:35
 */
@Service
public class UserServiceImpl implements UserService {
     private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User insertByUser(User user) {
        logger.info("新增用户"+user.toString());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User deleteUser = userRepository.getOne(userId);
        logger.info("删除用户"+deleteUser.toString());
        userRepository.delete(deleteUser);
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        logger.info("编辑用户"+user.toString());
        return user;
    }

    @Override
    public User findUser(Long userId) {
        logger.info("获取用户 ID : "+userId);
        return userRepository.getOne(userId);
    }
}
