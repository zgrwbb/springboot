package com.example.mybatisredisannotation.service;

import com.example.mybatisredisannotation.domain.City;

import java.util.List;

/**
 * 城市业务接口类
 *
 * @author wangbobo
 * @date 2018/7/9 14:45
 */
public interface CityService {
    /**
     * 根据城市id查询城市信息
     *
     * @param cityId cityId
     * @return city {@link City}
     */
    City getCityById(Long cityId);

    /**
     * 获取全部城市列表
     * @return List<City></City> {@link City}
     */
    List<City> getAllCity();

    /**
     * 新增城市
     * @param city city {@link City}
     * @return city
     */
    City saveCity(City city);

    /**
     * 修改城市
     * @param city city
     */
    void updateCity(City city);

    /**
     * 根据城市id删除城市
     * @param cityId cityId
     */
    void deleteCity(Long cityId);
}
