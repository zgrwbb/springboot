package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.City;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * cityservice
 *
 * @author wangbobo
 * @date 2018/6/27 22:02
 */
public interface CityService {
    /**
     * 保存城市
     *
     * @param city city
     * @return cityId
     */
    Long saveCity(City city);

    /**
     * And 语句查询
     * 根据城市描述和城市评分查询城市列表
     *
     * @param description 城市描述
     * @param score       城市评分
     * @return cityList
     */
    List<City> getCityByDescriptionAndScore(String description, Integer score);

    /**
     * OR 语句查询
     * 根据城市描述或城市评分查询城市列表
     *
     * @param description 城市描述
     * @param score       城市评分
     * @return cityList
     */
    List<City> getCityByDescriptionOrScore(String description, Integer score);

    /**
     * 根据城市描述查询城市列表
     * 等同于下面2行注释代码
     *
     * @param description 城市描述
     * @return cityPage
     */
    Page<City> getCityByDescription(String description);

    /*@Query("{\"bool\" : {\"must\" : {\"term\" : {\"description\" : \"?0\"}}}}")
    Page<City> findByDescription(String description, Pageable pageable);*/

    /**
     * 根据城市描述分页查询城市列表
     *
     * @param description 城市描述
     * @return cityPage
     */
    Page<City> getCityByDescriptionNot(String description);

    /**
     * 根据城市描述分页查询城市列表 模糊查询
     *
     * @param description 城市描述
     * @return cityPage
     */
    Page<City> getCityByDescriptionLike(String description);
}
