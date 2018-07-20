package com.example.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Created by wangbobo on 2018/7/20/17:01
 */
@RestController
public class HelloController {
    /**
     * webflux改变的地方
     * 返回类型: 返回类型为Mono<String> --> 响应式类型
     * 使用Mono.just生成响应式数据
     *
     * @return Mono<string>
     */
    @GetMapping(value = "/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world ~");
    }
}
