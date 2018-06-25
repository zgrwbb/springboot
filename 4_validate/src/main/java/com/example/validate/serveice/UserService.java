package com.example.validate.serveice;




import com.example.validate.domain.User;

import java.util.List;

/**
 * @author wangbobo
 * @date 2018/6/19 20:31
 */
public interface UserService {
    /**
     * 查询所有user
     *
     * @return userList
     */
    List<User> findAll();

    /**
     * 根据id查询user
     * @param userId  userId
     * @return user
     */
    User findUser(Long userId);

    /**
     * 新增一个User
     *
     * @param user user
     * @return user
     */
    User insertByUser(User user);

    /**
     * 删除user
     *
     * @param userId userId
     */
    void deleteUser(Long userId);

    /**
     * 编辑user
     *
     * @param user user
     * @return User {@link User}
     */
    User updateUser(User user);


}
