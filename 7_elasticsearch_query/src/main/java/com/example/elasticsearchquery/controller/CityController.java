package com.example.elasticsearchquery.controller;

import com.example.elasticsearchquery.domain.City;
import com.example.elasticsearchquery.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangbobo
 * @date 2018/7/4 17:34
 */
@RequestMapping(value = "/city")
@RestController
public class CityController {
    private Logger logger = LoggerFactory.getLogger(CityController.class);
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * 保存城市
     *
     * @param city {@link City}
     * @return Long cityId
     */
    @PostMapping(value = "saveCity")
    public Long saveCity(@RequestBody City city) {
        logger.info("\n保存城市 : " + city);
        return cityService.saveCity(city);
    }

    /**
     * 查询城市泪飙
     *
     * @param pageNumber    pageNumber
     * @param pageSize      pageSize
     * @param searchContent searchContent
     * @return List<City> {@link City}
     */
    @GetMapping(value = "searchCity")
    public List<City> searchCity(@RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam String searchContent) {
        return cityService.searchCity(pageNumber, pageSize, searchContent);
    }
}
