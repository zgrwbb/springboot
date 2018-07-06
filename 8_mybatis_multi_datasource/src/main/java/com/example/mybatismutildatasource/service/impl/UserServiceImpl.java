package com.example.mybatismutildatasource.service.impl;

import com.example.mybatismutildatasource.dao.cluster.CityDao;
import com.example.mybatismutildatasource.dao.master.UserDao;
import com.example.mybatismutildatasource.domain.master.User;
import com.example.mybatismutildatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangbobo
 * @date 2018/7/6 14:46
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 著数据源
     */
    private UserDao userDao;
    /**
     * 从数据源
     */
    private CityDao cityDao;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserServiceImpl(UserDao userDao, CityDao cityDao) {
        this.userDao = userDao;
        this.cityDao = cityDao;
    }

    @Override
    public User getUserByName(String userName) {
        User user = userDao.getUserByName(userName);
        user.setCity(cityDao.getCityByName("咸阳"));
        return user;
    }
}
