package com.example.mybatisredis.service.impl;

import com.example.mybatisredis.dao.CityDao;
import com.example.mybatisredis.domain.City;
import com.example.mybatisredis.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务实现类
 * redisTemplate.opsForValue();//操作字符串
 * redisTemplate.opsForHash();//操作hash
 * redisTemplate.opsForList();//操作list
 * redisTemplate.opsForSet();//操作set
 * redisTemplate.opsForZSet();//操作有序set
 * @author wangbobo
 */
@Service
public class CityServiceImpl implements CityService {
    private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
    private CityDao cityDao;
    private RedisTemplate<String, City> redisTemplate;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CityServiceImpl(CityDao cityDao, RedisTemplate<String, City> redisTemplate) {
        this.cityDao = cityDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<City> getAllCity() {
        logger.info("------> 获取全部城市列表");
        return cityDao.getAllCity();
    }

    /**
     * 根据城市id获取城市信息
     * 如果缓存中存在，从缓存中获取城市信息
     * 如果缓存中不存在，从DB中获取城市信息
     *
     * @param cityId cityId
     * @return city {@link City}
     */
    @Override
    public City getCityById(Long cityId) {
        //从缓存中获取城市信息
        String key = "city_" + cityId;
        //缓存中存在
        Boolean hasKey = redisTemplate.hasKey(key);
        if (null != hasKey && hasKey) {
            City city = redisTemplate.opsForValue().get(key);
            assert city != null;
            logger.info("\n------> 从缓存中根据id获取了城市信息\n" + city.toString());
            return city;
        }
        City city = cityDao.getCityById(cityId);
        // 顺便再放到缓存中下次使用
        redisTemplate.opsForValue().set(key, city);
        logger.info("\n------> 根据id从DB查询城市信息---并放到了缓存中\n" + city.toString());
        return city;
    }


    @Override
    public Long saveCity(City city) {
        cityDao.saveCity(city);
        Long cityId = city.getId();
        String key = "city_" + cityId;
        redisTemplate.opsForValue().set(key, city);
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey != null && hasKey) {
            logger.info("\n------> 保存城市成功把城市信息放入缓存中");
        }
        return cityId;
    }

    /**
     * 修改城市信息的时候一起存到缓存中
     * 如果缓存存在 删除
     * 如果不存在 不操作
     * redisTemplate.hasKey(key)返回的是一个封装类型Boolean
     * 所以要判断是否为空否则会出现空指针异常
     *
     * @param city {@link City}
     * @return cityId
     */
    @Override
    public Long updateCity(City city) {
        cityDao.updateCity(city);
        // 直接存 如果key重复或覆盖
        Long cityId = city.getId();
        String key = "city_" + cityId;
        redisTemplate.opsForValue().set(key, city);
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey != null && hasKey) {
            logger.info("\n------> 修改城市成功把城市信息放入缓存中");
        }
        return cityId;
    }

    @Override
    public Long deleteCity(Long cityId) {
        cityDao.deleteCity(cityId);
        logger.info("\n------> 从DB中删除城市信息");
        redisTemplate.delete("city_" + cityId);
        logger.info("\n------> 从缓存中删除城市信息");
        return cityId;
    }
}
