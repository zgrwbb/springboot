package com.example.mybatismutildatasource.dao.cluster;

import com.example.mybatismutildatasource.domain.cluster.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 城市Dao接口类
 *
 * @author wangbobo
 * @date 2018/7/6 14:17
 */
@Mapper
public interface CityDao {

    /**
     * 根据城市名称查找城市
     *
     * @param cityName cityName
     * @return City {@link City}
     */
    City getCityByName(@Param(value = "cityName") String cityName);

}
