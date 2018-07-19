package com.example.mybatisredisannotation.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * 城市实体类
 *
 * @author wangbobo
 * @date 2018/7/6 22:00
 */
public class City implements Serializable {


    private static final long serialVersionUID = -7935412059397103121L;
    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市描述
     */
    private String description;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                '}';
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
                Objects.equals(getProvinceId(), city.getProvinceId()) &&
                Objects.equals(getCityName(), city.getCityName()) &&
                Objects.equals(getDescription(), city.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProvinceId(), getCityName(), getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
