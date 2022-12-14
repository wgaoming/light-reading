package cn.zealon.readingcloud.homepage.service.impl;

import cn.zealon.readingcloud.common.cache.RedisBookKey;
import cn.zealon.readingcloud.common.cache.RedisExpire;
import cn.zealon.readingcloud.common.cache.RedisService;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.BookCenterService;
import cn.zealon.readingcloud.common.pojo.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zealon.readingcloud.book.feign.client.BookClient;
/**
 * 图书中心服务
 * @author: zealon
 * @since: 2019/7/4
 */
@Service
public class BookCenterServiceImpl implements BookCenterService {
    
    @Autowired
    private BookClient bookClient;

    @Autowired
    private RedisService redisService;

    @Autowired
    SearchServiceImpl searchService;
    @Override
    public Book getBookById(String bookId){
        //查看缓存中是否有该书信息
        String key = RedisBookKey.getBookKey(bookId);
        Book book = this.redisService.getCache(key, Book.class);
        if (book != null) {
            return book;
        }
        // 图书中心服务获取
        Result<Book> b=bookClient.getBookById(bookId);
        book = b.getData();
        if (book != null) {
            try {
                searchService.add(book, bookId);
            }catch (Exception e){
                System.out.println("存入ES失败："+e);
            }
        }
        return book;
    }
}
