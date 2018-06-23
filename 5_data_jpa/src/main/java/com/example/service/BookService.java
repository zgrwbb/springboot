package com.example.service;

import com.example.domain.Book;

import java.util.List;

/**
 * bookService接口
 * @author wangbobo
 * @date 2018/6/23 19:46
 */
public interface BookService {
    /**
     * 查询所有book
     * @return bookList
     */
    List<Book> findAllBook();

    /**
     * 通过id 查询book
     * @param id bookId
     * @return book
     */
    Book findBookById(Long id);

    /**
     * 新增一本书
     * @param book book
     * @return book
     */
    Book createBookByBook(Book book);

    /**
     * 根据id删除一本书
     * @param id bookId
     * @return book
     */
    Book deleteBookById(Long id);

    /**
     * 修改一本树
     * @param book book
     * @return book
     */
    Book updateBookByBook(Book book);
}
