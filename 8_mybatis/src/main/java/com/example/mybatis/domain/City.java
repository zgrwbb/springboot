package com.example.mybatis.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * 城市实体类
 *
 * @author wangbobo
 * @date 2018/7/4 22:08
 */
@SuppressWarnings("ALL")
public class City implements Serializable {
    /**
     * 城市编号 主键  Id
     */
    private Long id;

    /**
     * 省份编号 省份Id
     */
    private Long provinceId;

    /**
     * 城市名字
     */
    private String cityName;

    /**
     * 城市描述
     */
    private String description;

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
}
