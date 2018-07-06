package com.example.mybatismutildatasource.domain.master;

import com.example.mybatismutildatasource.domain.cluster.City;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户实体
 *
 * @author wangbobo
 * @date 2018/7/6 14:23
 */
@SuppressWarnings("WeakerAccess")
public class User implements Serializable {
    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 描述
     */
    private String description;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getDescription(), user.getDescription()) &&
                Objects.equals(getCity(), user.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getDescription(), getCity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    /**
     * 用户所在城市
     */
    private City city;
}
