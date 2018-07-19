package com.example.mybatisredisannotation.service.impl;

import com.example.mybatisredisannotation.dao.CityDao;
import com.example.mybatisredisannotation.domain.City;
import com.example.mybatisredisannotation.service.CityService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 城市业务实现类
 *
 * @author wangbobo
 * @date 2018/7/9 15:03
 */
@Service
@CacheConfig(cacheNames = "city")
public class CityServiceImpl implements CityService {
    private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Resource
    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    @CachePut(key = "#city.id")
    public City saveCity(@Param(value = "city") City city) {
        cityDao.saveCity(city);
        logger.info("\n---------------"+city.toString());
        return city;
    }

    @Override
    @Cacheable(key = "#cityId")
    public City getCityById(Long cityId) {
        return cityDao.getCityById(cityId);
    }

    @Override
    public List<City> getAllCity() {
        return cityDao.getAllCity();
    }

    @Override
    @CachePut(key = "#city.id")
    public void updateCity(City city) {
        cityDao.updateCity(city);
    }

    @Override
    @CacheEvict(key = "#cityId")
    public void deleteCity(Long cityId) {
        cityDao.deleteCity(cityId);
    }
}
