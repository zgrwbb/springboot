package com.example.mybatisannotation.service.impl;

import com.example.mybatisannotation.dao.CityDao;
import com.example.mybatisannotation.domain.City;
import com.example.mybatisannotation.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangbobo
 * @date 2018/7/5 17:30
 */
@Service
public class CityServiceImpl implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public City getCityByName(String cityName) {
        return cityDao.getCityByName(cityName);
    }
}
