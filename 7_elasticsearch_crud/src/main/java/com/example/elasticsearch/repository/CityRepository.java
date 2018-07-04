package com.example.elasticsearch.repository;

import com.example.elasticsearch.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * ES操作类
 *
 * @author wangbobo
 * @date 2018/6/27 21:39
 */
public interface CityRepository extends ElasticsearchRepository<City, Long> {

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
     * @param pageable    pageable
     * @return cityPage
     */
    Page<City> getCityByDescription(String description, Pageable pageable);

    /*@Query("{\"bool\" : {\"must\" : {\"term\" : {\"description\" : \"?0\"}}}}")
    Page<City> findByDescription(String description, Pageable pageable);*/

    /**
     * 根据城市描述分页查询城市列表
     * @param description 城市描述
     * @param pageable    pageable
     * @return cityPage
     */
    Page<City> getCityByDescriptionNot(String description, Pageable pageable);

    /**
     * 根据城市描述分页查询城市列表 模糊查询
     * @param description 城市描述
     * @param pageable    pageable
     * @return cityPage
     */
    Page<City> getCityByDescriptionLike(String description, Pageable pageable);
}
