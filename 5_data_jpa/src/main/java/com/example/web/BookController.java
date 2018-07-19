package com.example.web;

import com.example.domain.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * BookController
 *
 * @author wangbobo
 * @date 2018/6/23 18:34
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    private static final String BOOK_FORM_PATH_NAME = "bookForm";
    private static final String BOOK_LIST_PATH_NAME = "bookList";
    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";

    private final BookService bookService;

    /**
     * 使用构造器注入的好处：
     * 保证依赖不可变（final关键字）
     * 保证依赖不为空（省去了我们对其检查）
     * 保证返回客户端（调用）的代码的时候是完全初始化的状态
     * 避免了循环依赖
     * 提升了代码的可复用性
     *
     * 另外setter的方式能用让类在之后重新配置或者重新注入
     *
     * @param bookService bookService
     */
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查询bookList
     * 处理/book的GET请求
     *
     * @return 返回bookList
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.findAllBook());
        return BOOK_LIST_PATH_NAME;
    }

    /**
     * 创建book表单
     * 处理/book/create 的GET请求
     * @param modelMap modelMap
     * @return bookForm url
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookForm(ModelMap modelMap) {
        modelMap.addAttribute("book", new Book());
        modelMap.addAttribute("action", "create");
        return BOOK_FORM_PATH_NAME;
    }

    /**
     * 添加book
     * 处理/book/create 的POST请求
     * ModelAttribute 绑定表单实体参数，也通过 @RequestParam 传递参数
     * @param book book
     * @return bookList页面
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createBook(@ModelAttribute Book book) {
        bookService.createBookByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }

    /**
     * 获取修改book表单
     * 处理来自/book/update/{id} 的get请求
     * PathVariable 路径变量 拿到id
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.findBookById(id));
        modelMap.addAttribute("action", "update");
        return BOOK_FORM_PATH_NAME;
    }

    /**
     * 修改图书
     * 处理来自/book/update的post
     * @param book book
     * @return  REDIRECT_TO_BOOK_URL
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBookByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return REDIRECT_TO_BOOK_URL;
    }


}
