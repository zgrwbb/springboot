package com.example.pagingsorting.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangbobo
 * @date 2018/6/25 11:29
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
