package com.example.service;

import com.example.domain.Book;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * BookService 接口
 *
 * @author wangbobo
 */
public interface BookService {
    /**
     * 获取所有BookList
     *
     * @return List<Book>
     */
    List<Book> findAll();

    /**根据id查找book
     * @param bookId 编号
     * @return Book
     */
    Book findBookById(Long bookId);

    /**添加book
     * @param book book
     * @return Book
     */
    Book insertBook(Book book);

    /** 根据bookId 修改 book
     * @param book book
     * @return Book
     */
    Book updateBook(Book book);

    /**根据id删除book
     * @param bookId 编号
     * @return Book
     */
    Book deleteBook(Long bookId);
}
