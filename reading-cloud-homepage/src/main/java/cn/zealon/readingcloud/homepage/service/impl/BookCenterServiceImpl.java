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
import org.elasticsearch.common.xcontent.XContentType;
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

    private RestHighLevelClient client;
    @Autowired
    private BookClient bookClient;

    @Autowired
    private RedisService redisService;

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
                client=new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
                if(!Exists(client)){
                    Create(client);
                }
                add(book,client);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return book;
    }
    void add(Book book,RestHighLevelClient client) throws IOException {
        IndexRequest request=new IndexRequest("index");
        //向ES插入数据，必须将数据转成JSON格式
        ObjectMapper mapper=new ObjectMapper();
        String userJson=mapper.writeValueAsString(book);
        request.source(userJson, XContentType.JSON);

        IndexResponse response=client.index(request,RequestOptions.DEFAULT);
    }
    //创建索引库
    void Create(RestHighLevelClient client) throws IOException {
        //指定请求路径，参数是索引库名称
        CreateIndexRequest request=new CreateIndexRequest("index");
        //发起请求，indices返回包含索引库操作的所有方法,第二个参数是请求配置
        CreateIndexResponse createIndex = client.indices().create(request,RequestOptions.DEFAULT);
    }

    //判断ES库内是否已经存在索引
    public boolean Exists(RestHighLevelClient client) throws IOException {
        // 1.创建Request对象
        GetIndexRequest request = new GetIndexRequest();
        // 2.发送请求
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        // 3.输出
        return exists;
    }
}
