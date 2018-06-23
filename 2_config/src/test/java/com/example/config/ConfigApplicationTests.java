package com.example.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    BookProperties bookProperties;

    @Autowired
    BookComponent bookComponent;

    @Test
    public void testBookProperties() {
        System.out.println(bookProperties.getDesc());
    }

    @Test
    public void testBookComponent() {
        System.out.println(bookComponent.getDescription());
    }

}
