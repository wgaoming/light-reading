package cn.zealon.readingcloud.homepage.controller;

import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书查询接口
 * @author: zealon
 * @since: 2020/5/29
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    //"图书查询接口", httpMethod = "GET")
    @GetMapping("index/searchBooks")
    public Result getSearchResultBooks(String keyword, Integer page, Integer limit){
        return this.searchService.getSearchResultBooks(keyword, page, limit);
    }

//"获取热搜词接口", httpMethod = "GET")
    @GetMapping("index/getHotSearchWords")
    public Result getHotSearchWordList(Integer size){
        return this.searchService.getHotSearchWordList(size);
    }


}