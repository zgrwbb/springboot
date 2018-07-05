package com.example.mybatis.service.impl;

import com.example.mybatis.dao.CityDao;
import com.example.mybatis.domain.City;
import com.example.mybatis.service.CityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务实现类
 * @author wangbobo
 * @date 2018/7/5 14:11
 */
@Service
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(@SuppressWarnings("ALL") CityDao cityDao) {
        this.cityDao = cityDao;
    }

    /**
     * 根据城市名称查找城市
     * @param cityName cityName
     * @return City {@link City}
     */
    @Override
    public City getCityByName(@Param("cityName") String cityName) {
        return cityDao.getCityByName(cityName);
    }
}
