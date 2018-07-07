package com.example.mybatisredis.service;

import com.example.mybatisredis.domain.City;

import java.util.List;

/**
 * 城市业务接口
 * @author wangbobo
 * @date 2018/7/6 22:22
 */
public interface CityService {
    /**
     * 查询全部城市
     * @return List<City>{@link City}
     */
    List<City> getAllCity();

    /**
     * 根据城市编号获取城市
     *
     * @param cityId cityId
     * @return City {@link City}
     */
    City getCityById(Long cityId);

    /**
     * 保存城市
     * @param city {@link City}
     * @return cityId
     */
    Long saveCity(City city);

    /**
     * 修改城市
     * @param city city{@link City}
     * @return cityId
     */
    Long updateCity(City city);

    /**
     * 根据城市编号删除城市
     * @param cityId cityId
     * @return cityId
     */
    Long deleteCity(Long cityId);
}
