package com.example.cacheredis.service;

import com.example.cacheredis.domain.Book;

import java.util.List;

/**
 * @author wangbobo
 * @date 2018/6/26 22:24
 */
public interface BookService {

    /**
     * 查询所有图书
     *
     * @return List<book>
     */
    List<Book> findAll();

    /**
     * 根据id查询图书
     *
     * @param id bookId
     * @return Book
     */
    Book findById(Long id);

    /**
     * 保存图书
     *
     * @param book book
     * @return Book
     */
    Book saveBook(Book book);

    /**
     * 根据id删除图书
     * @param id bookId
     * @return Book
     */
    Book deleteBook(Long id);

    /**
     * 修改图书
     * @param book book
     * @return Book
     */
    Book updateBook(Book book);
}
