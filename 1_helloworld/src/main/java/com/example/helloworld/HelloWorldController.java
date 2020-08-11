package com.example.helloworld;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangbobo
 * @date 2018/6/11 14:20
 */
@Controller
@EnableScheduling

public class HelloWorldController {
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }
}
