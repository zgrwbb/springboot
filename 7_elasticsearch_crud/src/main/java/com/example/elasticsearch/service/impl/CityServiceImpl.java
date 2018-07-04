package com.example.elasticsearch.service.impl;

import com.example.elasticsearch.domain.City;
import com.example.elasticsearch.repository.CityRepository;
import com.example.elasticsearch.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangbobo
 * @date 2018/6/28 9:15
 */
@Service
public class CityServiceImpl implements CityService {
    private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
    /**
     *      分页参数 ->  代码可迁移到具体项目的公共 common 模块
     */
    private static  Integer pageNumber = 0;
    private static  Integer pageSize = 2;
    private Pageable pageable = PageRequest.of(pageNumber, pageSize);

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public Long saveCity(City city) {
        cityRepository.save(city);
        return city.getId();
    }

    @Override
    public List<City> getCityByDescriptionAndScore(String description, Integer score) {
        return cityRepository.getCityByDescriptionAndScore(description, score);
    }

    @Override
    public List<City> getCityByDescriptionOrScore(String description, Integer score) {
        return cityRepository.getCityByDescriptionOrScore(description, score);
    }

    @Override
    public Page<City> getCityByDescription(String description) {
        return cityRepository.getCityByDescription(description, pageable);
    }

    @Override
    public Page<City> getCityByDescriptionNot(String description) {
        return cityRepository.getCityByDescriptionNot(description, pageable);
    }

    @Override
    public Page<City> getCityByDescriptionLike(String description) {
        return cityRepository.getCityByDescriptionLike(description, pageable);
    }
}
