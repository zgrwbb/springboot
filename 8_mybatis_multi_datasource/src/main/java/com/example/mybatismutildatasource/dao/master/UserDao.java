package com.example.mybatismutildatasource.dao.master;

import com.example.mybatismutildatasource.domain.master.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Dao接口类
 *
 * @author wangbobo
 * @date 2018/7/6 14:28
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名查找用户
     *
     * @param userName userName 用户名
     * @return User {@link User}
     */
    User getUserByName(@Param(value = "userName") String userName);
}
