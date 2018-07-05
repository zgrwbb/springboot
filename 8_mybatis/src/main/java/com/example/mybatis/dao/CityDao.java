package com.example.mybatis.dao;

import com.example.mybatis.domain.City;

/**
 * 城市数据持久层接口
 * @author wangbobo
 * @date 2018/7/5 9:11
 */
public interface CityDao {
    /**
     * 根据城市名称查找城市
     * @param cityName cityName
     * @return {@link City}
     */
    City getCityByName(String cityName);
}
