package com.example.mybatisannotation.dao;

import com.example.mybatisannotation.domain.City;
import org.apache.ibatis.annotations.*;

/**
 * @author wangbobo
 * @date 2018/7/5 17:05
 * Mapper注解标记为Mybatis的Mapper
 */
@Mapper
public interface CityDao {
    /**
     * 根据城市名称查找城市
     *
     * @param cityName cityName 城市名称
     *                 Results 返回 Map 结果集
     * @return {@link City}
     */
    @Select({"select * from city where city_name=#{cityName} "})
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City getCityByName(@Param(value = "cityName") String cityName);
}
