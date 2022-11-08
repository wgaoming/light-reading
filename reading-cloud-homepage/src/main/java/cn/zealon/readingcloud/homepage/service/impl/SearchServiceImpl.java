package cn.zealon.readingcloud.homepage.service.impl;

import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.common.result.ResultUtil;
import cn.zealon.readingcloud.homepage.dao.HotSearchWordMapper;
import cn.zealon.readingcloud.homepage.domain.SearchBookItem;
import cn.zealon.readingcloud.homepage.domain.SearchBookResult;
import cn.zealon.readingcloud.homepage.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 图书查询服务
 * @author: zealon
 * @since: 2020/5/29
 */
@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);

    /** ES Jest 客户端对象 */
    @Autowired
    private RestHighLevelClient client;

    /** 索引别名 */
    @Value("${es.aliasName}")
    private String aliasName;

    /** 类型 */
    @Value("${es.indexType}")
    private String indexType;

    @Autowired
    private HotSearchWordMapper hotSearchWordMapper;

    @Override
    public Result getHotSearchWordList(Integer size) {
        List<String> hotSearchWordList = this.hotSearchWordMapper.getHotSearchWordList(size);
        return ResultUtil.success(hotSearchWordList);
    }

    @Override
    public Result getSearchResultBooks(String keyword, Integer page, Integer limit){
        SearchSourceBuilder builder=new SearchSourceBuilder();
        int from = (page - 1) * limit;
        int size = from + limit;
        builder.from(from);
        builder.size(size);
        builder.query(QueryBuilders.fuzzyQuery("bookName",keyword));
        SearchBookResult searchBookResult = this.getSearchResult(builder);

        return ResultUtil.success(searchBookResult);
    }

    /**
     * ES 执行查询结果
     * @param query
     * @return
     */
    private SearchBookResult getSearchResult(SearchSourceBuilder query){
        SearchBookResult result = new SearchBookResult();
        SearchRequest request=new SearchRequest().indices("index");
        request.source(query);
        // 执行查询
        try {
            SearchResponse response=client.search(request, RequestOptions.DEFAULT);

            List<SearchBookItem> bookList=new ArrayList<>();
            // 查询成功，处理结果项
            SearchHits hits=response.getHits();
            for(SearchHit hit : hits) {
                bookList.add(new Gson().fromJson(hit.getSourceAsString(),SearchBookItem.class));
            }
            // 赋值
            result.setTotal(bookList.size());
            result.setBookList(bookList);
        } catch (IOException e) {
            LOGGER.error("查询图书异常，查询语句:{}", query, e);
        }
        return result;
    }
    //创建索引库
    public void create() {
        try {
            //指定请求路径，参数是索引库名称
            CreateIndexRequest request = new CreateIndexRequest("index");
            //发起请求，indices返回包含索引库操作的所有方法,第二个参数是请求配置
            CreateIndexResponse createIndex = client.indices().create(request, RequestOptions.DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //判断ES库内是否已经存在索引
    public boolean Exists(){
        boolean exists=false;
        try {
            // 1.创建Request对象
            GetIndexRequest request = new GetIndexRequest("index");
            // 2.发送请求
            exists = client.indices().exists(request, RequestOptions.DEFAULT);

        }catch (IOException e){
            e.printStackTrace();
        }
        return exists;
    }
    public void delete(){
        try {
            DeleteIndexRequest request = new DeleteIndexRequest("index");
            client.indices().delete(request, RequestOptions.DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void add(Book book, String id){
        try {
            IndexRequest request = new IndexRequest("index").id(id);
            ObjectMapper mapper = new ObjectMapper();
            String userJson = mapper.writeValueAsString(book);
            request.source(userJson, XContentType.JSON);
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            LOGGER.info(response.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
