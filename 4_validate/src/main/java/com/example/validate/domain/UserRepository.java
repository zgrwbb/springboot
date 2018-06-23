package com.example.validate.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangbobo
 * @date 2018/6/19 20:08
 */
public interface UserRepository extends JpaRepository<User ,Long> {
}
