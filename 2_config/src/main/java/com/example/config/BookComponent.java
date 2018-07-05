package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 书属性
 *
 * @author wangbobo
 * @date 2018/6/11 16:31
 */
@Validated
@Component
@ConfigurationProperties(prefix = "demo.book")
public class BookComponent {
    /**
     * 书名
     */
    @NotEmpty
    private String name;
    /**
     * 作者
     */
    @NotNull
    private String writer;
    /**
     * 描述
     */
    @NotEmpty
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "BookComponent{" +
                "name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
