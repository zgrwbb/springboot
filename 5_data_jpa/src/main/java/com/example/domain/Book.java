package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * book 实体类
 * @author wangbobo
 * @date 2018/6/23 19:41
 */
@Entity
public class Book implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String writer;
    /**
     * 简介
     */
    private String introduction;

    public Long getId() {
        return id;
    }

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
