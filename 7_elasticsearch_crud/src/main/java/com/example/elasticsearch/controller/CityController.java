package com.example.elasticsearch.controller;

import com.example.elasticsearch.domain.City;
import com.example.elasticsearch.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangbobo
 * @date 2018/7/3 20:42
 */
@RestController
@RequestMapping("/city/")
public class CityController {

    private Logger logger = LoggerFactory.getLogger(CityController.class);

    private CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    /**
     * 保存城市
     * @param city city
     * @return Long cityId
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public Long saveCity(@RequestBody City city) {
        logger.info("保存城市,cityId : "+ city.getId());
        return cityService.saveCity(city);
    }

    /**
     * 根据城市描述和城市评分获取城市列表
     * @param description description
     * @param score score
     * @return cityList
     */
    @RequestMapping(value = "getCityByDescriptionAndScore",method = RequestMethod.GET)
    public List<City> getCityByDescriptionAndScore(@RequestParam String description,@RequestParam Integer score) {
        logger.info("根据城市描述和城市评分获取城市列表");
        return cityService.getCityByDescriptionAndScore(description, score);
    }

    /**
     * 根据城市描述或城市评分获取城市列表
     * @param description description
     * @param score score
     * @return cityList
     */
    @RequestMapping(value = "getCityByDescriptionOrScore",method = RequestMethod.GET)
    public List<City> getCityByDescriptionOrScore(@RequestParam String description,@RequestParam Integer score) {
        logger.info("--AND-- 根据城市描述或城市评分获取城市列表");
        return cityService.getCityByDescriptionOrScore(description, score);
    }

    /**
     * 根据城市描述分页获取城市列表
     * @param description description
     * @return cityPage
     */
    @RequestMapping(value = "getCityByDescription",method = RequestMethod.GET)
    public Page<City> getCityByDescription(@RequestParam String description) {
        logger.info("--OR-- 根据城市描述分页获取城市列表");
        return cityService.getCityByDescription(description);
    }

    /**
     * 根据城市描述分页获取不符合描述的城市列表
     * @param description description
     * @return cityPage
     */
    @RequestMapping(value = "getCityByDescriptionNot",method = RequestMethod.GET)
    public Page<City> getCityByDescriptionNot(@RequestParam String description) {
        logger.info("--NOT-- 根据城市描述分页获取不符合描述的城市列表");
        return cityService.getCityByDescriptionNot(description);
    }

    /**
     * 根据城市描述分页模糊查询城市列表
     * @param description description
     * @return cityPage
     */
    @RequestMapping(value = "getCityByDescriptionLike",method = RequestMethod.GET)
    public Page<City> getCityByDescriptionLike(@RequestParam String description) {
        logger.info("--LIKE-- 根据城市描述分页模糊查询城市列表");
        return cityService.getCityByDescriptionLike("%"+description+"%");
    }
}
