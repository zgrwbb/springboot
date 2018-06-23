package com.example.web;

import com.example.config.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbobo
 * @date 2018/6/11 15:50
 */
@RestController
public class BookController {
    private final BookProperties bookProperties;

    @Autowired
    public BookController(BookProperties bookProperties) {
        this.bookProperties = bookProperties;
    }


    @RequestMapping(value = "/hello/book")
    public String sayHello() {
        return bookProperties.getDesc();
    }
}
