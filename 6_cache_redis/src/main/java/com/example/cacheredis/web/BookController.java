package com.example.cacheredis.web;

import com.example.cacheredis.domain.Book;
import com.example.cacheredis.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangbobo
 * @date 2018/6/26 22:40
 */
@RequestMapping(value = "/book")
@Controller
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 处理/book的GET请求
     * 获取bookList
     * @param modelMap modelMap
     * @return bookList
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap modelMap) {
        modelMap.put("bookList", bookService.findAll());
        return "bookList";
    }

    /**
     * 处理/book/create 的GET请求
     * 获取bookForm表单页面
     * @param modelMap modelMap
     * @return bookForm
     */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String getCreateBookForm(ModelMap modelMap) {
        modelMap.put("book", new Book());
        modelMap.put("action", "create");
        return "bookForm";
    }

    /**
     * 处理/book/create的POST请求
     * 添加图书并跳转到 bookList页面
     * 通过 @ModelAttribute 绑定表单实体参数，也通过 @RequestParam 传递参数
     * @param book book
     * @return book
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBook(@ModelAttribute Book book) {
        Book book1= bookService.saveBook(book);
        logger.info("新增 --- "+book1.toString());
        return REDIRECT_TO_BOOK_URL;
    }

    /**
     * 处理/book/update/{id}的GET请求
     * 获取bookForm表单页面
     * 通过 @PathVariable 路径变量 绑定url中传过来的id
     * 通过 @ModelAttribute 绑定表单实体参数
     * @param modelMap modelMap
     * @return bookForm
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getUpdateBookForm(@PathVariable Long id,ModelMap modelMap) {
        modelMap.put("book", bookService.findById(id));
        modelMap.put("action", "update");
        return "bookForm";
    }

    /**
     * 处理/book/update的POST请求
     * 修改图书后重定向到bookList
     * @param book book
     * @return 重定向到 bookList
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateBook(@ModelAttribute Book book) {
        Book book1=bookService.updateBook(book);
        logger.info("修改 --- "+book1.toString());
        return REDIRECT_TO_BOOK_URL;
    }

    /**
     * 处理/book/delete的GET请求
     * 根据id删除book后重定向到bookList
     * @param id bookId
     * @return 重定向到bookList
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        logger.info("删除 --- "+book.toString());
        bookService.deleteBook(id);
        return REDIRECT_TO_BOOK_URL;
    }

}
