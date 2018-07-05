package com.example.mybatis.service;

import com.example.mybatis.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * 城市业务接口
 * @author wangbobo
 * @date 2018/7/5 14:09
 */
public interface CityService {
    /**
     * 根据城市名称查找城市
     * @param cityName cityName
     * @return {@link City}
     */
    City getCityByName(@Param("cityName") String cityName);
}
