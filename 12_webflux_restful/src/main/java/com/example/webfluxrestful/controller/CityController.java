package com.example.webfluxrestful.controller;

import com.example.webfluxrestful.domain.City;
import com.example.webfluxrestful.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Created by wangbobo on 2018/7/20/18:55
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    private final CityHandler cityHandler;

    @Autowired
    public CityController(CityHandler cityHandler) {
        this.cityHandler = cityHandler;
    }

    @GetMapping(value = "/{id}")
    public Mono<City> getCityById(@PathVariable Long id) {
        return cityHandler.getCityById(id);
    }

    @GetMapping()
    public Flux<City> getAll() {
        return cityHandler.getAll();
    }

    @PostMapping()
    public Mono<Long> save(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @PutMapping()
    public Mono<Long> update(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> delete(@PathVariable Long id) {
        return cityHandler.deleteCity(id);
    }

}
