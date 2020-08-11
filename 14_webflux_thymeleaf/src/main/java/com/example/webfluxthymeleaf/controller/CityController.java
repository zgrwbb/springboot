package com.example.webfluxthymeleaf.controller;

import com.example.webfluxthymeleaf.domain.City;
import com.example.webfluxthymeleaf.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wangbobo
 */
@Controller
@RequestMapping(value = "/city")
public class CityController {

    private final CityHandler cityHandler;

    @Autowired
    public CityController(CityHandler cityHandler) {
        this.cityHandler = cityHandler;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping()
    @ResponseBody
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @PostMapping()
    @ResponseBody
    public Mono<Long> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @PutMapping()
    @ResponseBody
    public Mono<Long> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }

    @GetMapping("/hello")
    public Mono<String> hello(final Model model) {
        model.addAttribute("name", "嬴政");
        model.addAttribute("city", "陕西咸阳");

        String path = "hello";
        return Mono.create(monoSink -> monoSink.success(path));
    }

    private static final String CITY_LIST_PATH_NAME = "cityList";

    @GetMapping("/page/list")
    public String listPage(final Model model) {
        final Flux<City> cityFluxList = cityHandler.findAllCity();
        model.addAttribute(CITY_LIST_PATH_NAME, cityFluxList);
        return CITY_LIST_PATH_NAME;
    }

}
