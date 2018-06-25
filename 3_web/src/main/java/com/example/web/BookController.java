package com.example.web;

import com.example.domain.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Book 控制层
 * @author wangbobo
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBookList() {
        return bookService.findAll();
    }

    /**
     * 获取 Book
     * 处理 "/book/{id}" 的 GET 请求，用来获取 Book 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @RequestBody 绑定实体参数，也通过 @RequestParam 传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book) {
        return bookService.insertByBook(book);
    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Book putBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable("id") Long id) {
        return bookService.delete(id);
    }

}
