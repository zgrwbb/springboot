package com.example.mybatisredis.controller;

import com.example.mybatisredis.domain.City;
import com.example.mybatisredis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市控制层
 *
 * @author wangbobo
 * @date 2018/7/6 22:40
 */
@RestController
@RequestMapping(value = "/api/")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "all")
    public List<City> getAllCity() {
        return cityService.getAllCity();
    }

    @GetMapping(value = "{cityId}")
    public Object getCityById(@PathVariable Long cityId) {
        return cityService.getCityById(cityId);
    }

    @PostMapping()
    public Long saveCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @PutMapping()
    public Long updateCity(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @RequestMapping(value = "{cityId}", method = RequestMethod.DELETE)
    public Long deleteCity(@PathVariable Long cityId) {
        return cityService.deleteCity(cityId);
    }
}
