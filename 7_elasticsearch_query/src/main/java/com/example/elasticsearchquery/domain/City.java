package com.example.elasticsearchquery.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wangbobo
 * @date 2018/7/4 11:15
 */
@SuppressWarnings("ALL")
@Document(indexName = "province", type = "city")
public class City implements Serializable {
    private static final Long serialVersionUID = -1L;
    /**
     * 城市编号
     */
    private Long id;
    /**
     * 城市名称
     */
    private String name;

    /**
     * 城市描述
     */
    private String description;
    /**
     * 城市评分
     */
    private Integer score;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(getId(), city.getId()) &&
                Objects.equals(getName(), city.getName()) &&
                Objects.equals(getDescription(), city.getDescription()) &&
                Objects.equals(getScore(), city.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getScore());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }
}
