package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangbobo
 * @date 2018/7/4 21:14
 */
@Configuration
public class MessageConfiguration {
    @Bean
    public String message() {
        return "message configuration !";
    }
}
