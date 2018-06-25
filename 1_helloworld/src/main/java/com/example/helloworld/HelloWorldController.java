package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangbobo
 * @date 2018/6/11 14:20
 */
@Controller
public class HelloWorldController {
    @RequestMapping("helloworld")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }
}
