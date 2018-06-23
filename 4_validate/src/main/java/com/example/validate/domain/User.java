package com.example.validate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 用户实体类
 * @author wangbobo
 * @date 2018/6/19 20:09
 */
@Entity
public class User implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @NotEmpty(message = "名称不能为空")
    @Size(min = 2, max = 8, message = "名称必须为2-8个汉字")
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "不能为空")
    @Min(value = 0, message = "年龄必须大于0")
    @Max(value = 300, message = "年龄不能大于300")
    private int age;

    /**
     * 生日
     */
    @NotEmpty(message = "生日不能为空")
    private String birthday;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
