package com.example.mybatisredis.service.impl;

import com.example.mybatisredis.dao.CityDao;
import com.example.mybatisredis.domain.City;
import com.example.mybatisredis.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务实现类
 *
 * @author wangbobo
 * @date 2018/7/6 22:23
 */
@Service
public class CityServiceImpl implements CityService {
    private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    private CityDao cityDao;
    private RedisTemplate<String, City> redisTemplate;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public CityServiceImpl(CityDao cityDao, RedisTemplate<String, City> redisTemplate) {
        this.cityDao = cityDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<City> getAllCity() {
        logger.info("------> 获取全部城市列表");
        return cityDao.getAllCity();
    }

    @Override
    public City getCityById(Long cityId) {
        //从缓存中获取城市信息
        String key = "city_" + cityId;
        ValueOperations<String, City> stringCityValueOperations = redisTemplate.opsForValue();

        //缓存中存在
        if (redisTemplate.hasKey(key)) {
            City city = stringCityValueOperations.get(key);
            assert city != null;
            logger.info("CityServiceImpl.getCityById(cityId) : 从缓存中获取了城市---> " + city.toString());
            return city;
        }
        City city = cityDao.getCityById(cityId);
        logger.info("从DB中获取了城市---> "+city.toString());
        return city;
    }

    @Override
    public Long saveCity(City city) {
        cityDao.saveCity(city);
        return null;
    }

    @Override
    public Long updateCity(City city) {
        return null;
    }

    @Override
    public Long deleteCity(Long cityId) {
        return null;
    }
}
