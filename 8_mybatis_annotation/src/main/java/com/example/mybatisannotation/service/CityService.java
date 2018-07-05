package com.example.mybatisannotation.service;

import com.example.mybatisannotation.domain.City;

/**
 * @author wangbobo
 * @date 2018/7/5 17:14
 */
public interface CityService {

    /**
     * 根据城市名称查找城市
     *
     * @param cityName cityName 城市名称
     * @return City {@link City}
     */
    City getCityByName(String cityName);
}
