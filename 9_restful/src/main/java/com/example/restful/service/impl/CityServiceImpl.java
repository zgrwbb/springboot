package com.example.restful.service.impl;

import com.example.restful.domain.City;
import com.example.restful.mapper.CityMapper;
import com.example.restful.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangbobo 2018/7/19/19:51
 */
@Service
public class CityServiceImpl implements CityService {
    private CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public List<City> findAllCity() {
        return cityMapper.findAllCity();
    }

    @Override
    public City findCityById(Long cityId) {
        return cityMapper.findCityById(cityId);
    }

    @Override
    public Long saveCity(City city) {
        return cityMapper.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    @Override
    public Long deleteCity(Long cityId) {
        return cityMapper.deleteCity(cityId);
    }

}
