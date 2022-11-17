package cn.zealon.readingcloud.homepage.service.impl;

import cn.zealon.readingcloud.common.cache.RedisBookKey;
import cn.zealon.readingcloud.common.cache.RedisExpire;
import cn.zealon.readingcloud.common.cache.RedisService;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.BookCenterService;
import cn.zealon.readingcloud.common.pojo.book.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zealon.readingcloud.book.feign.client.BookClient;

import java.io.IOException;

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
        String key = RedisBookKey.BookCenter.getFeignClientBookKey(bookId);
        Book book = this.redisService.getCache(key, Book.class);
        if (book != null) {
            return book;
        }

        // 图书中心服务获取
        Result<Book> b=bookClient.getBookById(bookId);
        book = b.getData();
        if (book != null) {
            this.redisService.setExpireCache(key, book, RedisExpire.HOUR);
            try {
                searchService.add(book, bookId);
            }catch (Exception e){
                System.out.println("存入ES失败："+e);
            }
        }
        return book;
    }
}
