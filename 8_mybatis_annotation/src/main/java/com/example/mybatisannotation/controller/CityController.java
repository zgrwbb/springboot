package com.example.mybatisannotation.controller;

import com.example.mybatisannotation.domain.City;
import com.example.mybatisannotation.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbobo
 * @date 2018/7/5 17:46
 */
@RestController
@RequestMapping(value = "/city/")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "getCityByName")
    public City getCityByName(@RequestParam String cityName) {
        return cityService.getCityByName(cityName);
    }
}
