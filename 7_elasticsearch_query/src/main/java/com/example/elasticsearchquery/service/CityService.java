package com.example.elasticsearchquery.service;

import com.example.elasticsearchquery.domain.City;

import java.util.List;

/**
 * ES service接口
 * @author wangbobo
 * @date 2018/7/4 11:18
 */
public interface CityService {
    /**
     * ES 保存city
     *
     * @param city city
     * @return Long cityId
     */
    Long saveCity(City city);

    /**
     * 根据搜索内容分页查询城市列表
     * @param pageNumber pageNumber
     * @param pageSize pageSize
     * @param searchContext searchContext
     * @return cityList
     */
    List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContext);
}
