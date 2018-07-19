package com.example.mybatisredisannotation.dao;

import com.example.mybatisredisannotation.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wangbobo 2018/7/19/16:17
 */
@Mapper
public interface CityDao {
    /**
     * 根据城市id 获取城市
     * @param cityId 城市id
     * @return {@link City}
     */
    @Select("select * from city where id = #{cityId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City getCityById( Long cityId);

    /**
     * 获取全部城市
     * @return List<City></City> {@link City}
     */
    List<City> getAllCity();

    /**
     * 新增城市
     * @param city 城市 {@link City}
     * @return cityId
     */
    @Insert("insert into city (province_id,city_name,description) values(#{city.provinceId},#{city.cityName},#{city.description})")
    @SelectKey(before = false, statement = "select LAST_INSERT_ID() as id", keyProperty = "city.id", resultType = Long.class)
    Long saveCity(@Param(value = "city") City city);

    /**
     * 修改城市
     * @param city city {@link City}
     */
    void updateCity(City city);

    /**
     * 根据城市id修改城市
     * @param cityId 城市id
     */
    void deleteCity(Long cityId);

    Long selectLastKey();

}
