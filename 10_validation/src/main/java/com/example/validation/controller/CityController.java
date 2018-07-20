package com.example.validation.controller;

import com.example.validation.constant.CityInfoEnum;
import com.example.validation.domain.City;
import com.example.validation.exception.GlobalException;
import com.example.validation.result.ResultBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by wangbobo on 2018/7/20/16:23
 */
@RestController
public class CityController {
    @DeleteMapping(value = "/api/city")
    public ResultBody getCityById(@RequestBody City city) throws GlobalException {
        if (null==city.getId()) {
            throw new GlobalException(CityInfoEnum.MISSING_PARAMETER);
        }
        City city1 = new City();
        city1.setId(1L);
        city1.setProvinceId(1L);
        city1.setCityName("西安");
        city1.setDescription("长安");
        List<City> cities = new ArrayList<>();
        cities.add(city1);
        return new ResultBody(cities);
    }
}
