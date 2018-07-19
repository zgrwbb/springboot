package com.example.restful.mapper;

import com.example.restful.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wangbobo 2018/7/19/19:52
 */
@Mapper
public interface CityMapper {
    /**
     * 获取城市列表
     *
     * @return 城市列表 List<City></> {@link City}
     */
    @Select("select * from city")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    List<City> findAllCity();

    /**
     * 根据城市id获取城市信息
     *
     * @param cityId 城市id
     * @return City {@link City}
     */
    @Select("select * from city where id=#{cityId}")
    City findCityById(Long cityId);

    /**
     * 保存城市信息
     *
     * @param city city {@link City}
     * @return cityId
     */
    @Insert("insert into city (province_id,city_name,description) values(#{city.provinceId},#{city.cityName},#{city.description})")
    Long saveCity(City city);

    /**
     * 修改城市信心
     *
     * @param city city {@link City}
     * @return cityId
     */
    @Update({"update city set province_id=#{city.provinceId}, city_name=#{city.cityName}, description=#{city.description} where id=#{city.id}"})
    Long updateCity(City city);

    /**
     * 根据城市id删除城市信心
     *
     * @param cityId cityId
     * @return Long cityId
     */
    @Delete("delete from city where id=#{cityId}")
    Long deleteCity(Long cityId);
}
