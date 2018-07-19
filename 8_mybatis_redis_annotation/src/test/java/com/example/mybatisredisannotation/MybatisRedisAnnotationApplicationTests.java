package com.example.mybatisredisannotation;

import com.example.mybatisredisannotation.domain.City;
import com.example.mybatisredisannotation.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisRedisAnnotationApplicationTests {

    private Logger logger = LoggerFactory.getLogger(MybatisRedisAnnotationApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Autowired
    private CityService cityService;

    /**
     * 测试向redis中存入城市
     */
    @Test
    public void testSaveCity() {
        City city = new City();
        city.setProvinceId(10L);
        city.setCityName("上海");
        city.setDescription("魔都");
        cityService.saveCity(city);
    }

    /**
     * 测试向redis中存入城市
     */
    @Test
    public void testGetCityById() {
        City city = cityService.getCityById(2L);
        logger.info(city.toString());
    }

}
