package com.example.service;

import com.example.domain.Book;

import java.util.List;

/**
 * Book 业务接口层
 * @author wangbobo
 */
public interface BookService {
    /**
     * 获取所有 Book
     * @return  List<Book>
     */
    List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     * @return Book {@link Book}
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     * @return Book {@link Book}
     */
    Book update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     *           @return Book {@link Book}
     */
    Book delete(Long id);

    /**
     * 获取 Book
     *
     * @param id 编号
     *           @return Book {@link Book}
     */
    Book findById(Long id);
}
