package com.example.cacheredis.service.impl;

import com.example.cacheredis.domain.Book;
import com.example.cacheredis.domain.BookRepository;
import com.example.cacheredis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author wangbobo
 * @date 2018/6/26 22:31
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {
    /*
    @Cacheable 触发缓存入口
    @CacheEvict 触发移除缓存
    @CachePut 更新缓存
    @Caching 将多种缓存操作分组
    @CacheConfig 类级别的缓存注解，允许共享缓存名称
    */
    /**
     * bookRepository
     */
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    /**
     * 注解 @Cacheable
     * 注解 @Cacheable(value = "bookList",key = "#*")
     * @return bookList
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 自定义策略是指我们可以通过Spring的EL表达式来指定我们的key。
     * 这里的EL表达式可以使用方法参数及它们对应的属性。
     * 使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”---例 #p0。
     * 下面是几个使用参数作为key的示例。
     * 本方法的#p0 相当于 #id
     * 注解: @Cacheable(key = "#p0")
     * @param id bookId
     * @return book
     */
    @Cacheable(key = "#id")
    @Override
    public Book findById( Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    @CachePut(key = "#p0.id")
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @CacheEvict(key = "#p0")
    public Book deleteBook(Long id) {
        Book book = bookRepository.getOne(id);
        bookRepository.delete(book);
        return book;
    }

    /**
     * 这里#p0 就是book,#p0.id 就是book.id 相当于#book.id
     * 如果还有一个参数比如 public Book updateBook(Book book,Long id)
     * key='#p1' 就是Long id
     * 注解: @CachePut(key = "#p0.id")
     * @param book book
     * @return Book
     */
    @Override
    @CachePut(key = "#book.id")
    public Book updateBook(Book book) {
        bookRepository.save(book);
        return book;
    }
}
