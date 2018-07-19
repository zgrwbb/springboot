package com.example.restful.service;

import com.example.restful.domain.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * @author wangbobo 2018/7/19/19:46
 */
public interface CityService {
    /**
     * 获取城市列表
     *
     * @return 城市列表 List<City></> {@link City}
     */
    List<City> findAllCity();

    /**
     * 根据城市id获取城市信息
     *
     * @param cityId 城市id
     * @return City {@link City}
     */
    City findCityById(Long cityId);

    /**
     * 保存城市信息
     *
     * @param city city {@link City}
     * @return cityId
     */
    Long saveCity(City city);

    /**
     * 修改城市信心
     *
     * @param city city {@link City}
     * @return cityId
     */
    Long updateCity(City city);

    /**
     * 根据城市id删除城市信心
     *
     * @param cityId cityId
     * @return Long cityId
     */
    Long deleteCity(Long cityId);

}
