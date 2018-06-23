package com.example.service.impl;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * bookService层实现类
 *
 * @author wangbobo
 * @date 2018/6/23 19:53
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book createBookByBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book deleteBookById(Long id) {
        bookRepository.delete(bookRepository.getOne(id));
        return bookRepository.getOne(id);
    }

    @Override
    public Book updateBookByBook(Book book) {
        bookRepository.save(book);
        return book;
    }
}
