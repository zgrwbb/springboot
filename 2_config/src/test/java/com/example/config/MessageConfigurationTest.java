package com.example.config;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author wangbobo
 * @date 2018/7/4 21:16
 */
public class MessageConfigurationTest {
    private Logger logger = LoggerFactory.getLogger(MessageConfigurationTest.class);

    @Test
    public void testGetMessageBean() {
        // 加载配置类 相当于以前的加载配置文件
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        String messageProperties = annotationConfigApplicationContext.getBean("message").toString();
        assertEquals("message configuration !", messageProperties);
        logger.info("----------> "+messageProperties);
    }

    @Test
    public void testScanPackages() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.example.config");
        // refresh  主要执行方法
        annotationConfigApplicationContext.refresh();
        String messageProperties = annotationConfigApplicationContext.getBean("message").toString();
        assertEquals("message configuration !", messageProperties);
        logger.info("----------> "+messageProperties);
    }
}