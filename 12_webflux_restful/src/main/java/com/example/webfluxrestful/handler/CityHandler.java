package com.example.webfluxrestful.handler;

import com.example.webfluxrestful.dao.CityRepository;
import com.example.webfluxrestful.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Created by wangbobo on 2018/7/20/18:32
 */
@Component
public class CityHandler {
    private final CityRepository cityRepository;

    @Autowired
    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<Long> save(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city).getId()));
    }

    public Mono<City> getCityById(Long id) {
        return Mono.justOrEmpty(cityRepository.findById(id));
    }

    public Flux<City> getAll() {
        return Flux.fromIterable(cityRepository.findAll());
    }

    public Mono<Long> modifyCity(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city).getId()));
    }

    public Mono<Long> deleteCity(Long id) {
        cityRepository.delete(cityRepository.getOne(id));
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }
}
