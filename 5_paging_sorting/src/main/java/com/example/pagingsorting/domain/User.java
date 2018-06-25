package com.example.pagingsorting.domain;

import org.apache.commons.lang3.time.DateFormatUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用户实体类
 *
 * @author wangbobo
 * @date 2018/6/25 11:11
 */
@Entity
public class User implements Serializable {
    /**
     * id 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
    /**
     * 生日
     */
    private Date birthday;

    private Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String getBirthday() {
        return DateFormatUtils.format(birthday, "yyyy-MM-dd");
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
        return getAge() == user.getAge() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getBirthday(), user.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getBirthday());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
