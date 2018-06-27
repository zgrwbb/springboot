package com.example.cacheredis.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangbobo
 * @date 2018/6/26 22:23
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
