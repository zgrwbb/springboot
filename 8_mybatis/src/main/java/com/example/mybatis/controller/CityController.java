package com.example.mybatis.controller;

import com.example.mybatis.domain.City;
import com.example.mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbobo
 * @date 2018/7/5 14:16
 */
@RestController
@RequestMapping(value = "/city/")
public class CityController {

    private final CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * 根据城市名称查找城市
     * @param cityName cityName
     * @return City {@link City}
     */
    @GetMapping(value = "getCityByName")
    public City getCityByName(@RequestParam String cityName) {
        return cityService.getCityByName(cityName);
    }
}
