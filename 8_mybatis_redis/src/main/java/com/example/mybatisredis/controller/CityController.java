package com.example.mybatisredis.controller;

import com.example.mybatisredis.domain.City;
import com.example.mybatisredis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 城市控制层
 * @author wangbobo
 * @date 2018/7/6 22:40
 */
@RestController
@RequestMapping(value = "/city/")
public class CityController {
    private CityService cityService;
    @Autowired
    public CityController(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping()
    public List<City> getAllCity() {
        return cityService.getAllCity();
    }
}
