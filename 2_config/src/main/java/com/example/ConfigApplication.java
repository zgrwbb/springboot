package com.example;

import com.example.config.BookComponent;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Spring Boot 应用启动类
 * 注解 EnableSwagger2Doc 开启 Swagger
 *
 * @author bysocket
 * @date 26/09/2017
 */
@EnableSwagger2Doc
@SpringBootApplication
@EnableConfigurationProperties(BookComponent.class)
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }


}
