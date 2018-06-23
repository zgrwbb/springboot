package com.example.service.impl;

import com.example.domain.Book;
import com.example.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangbobo
 * @date 2018/6/23 18:27
 */
@Service
public class BookServiceImpl implements BookService {
    /**
     * 模拟数据库
     * 第五章《﻿数据存储》会替换成 H2 数据源存储
     */
    private static Map<Long, Book> BOOK_DB = new HashMap<>(16);

///    private Book book;

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(BOOK_DB.values());
    }

    @Override
    public Book findBookById(Long bookId) {

        return BOOK_DB.get(bookId);
    }

    @Override
    public Book insertBook(Book book) {
        book.setId(BOOK_DB.size()+1L);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book deleteBook(Long bookId) {

        return BOOK_DB.remove(bookId);
    }
}
