package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * book持久层接口 相当于dao
 * @author wangbobo
 * @date 2018/6/23 19:44
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
