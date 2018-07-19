package com.example.restful.controller;

import com.example.restful.domain.City;
import com.example.restful.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangbobo 2018/7/19/21:41
 */
@RestController
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping(value = "/api/city/{id}")
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping(value = "/api/city")
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @PostMapping(value = "/api/city")
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @PutMapping(value = "/api/city")
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @DeleteMapping(value = "/api/city/{id}")
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
