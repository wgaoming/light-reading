package cn.zealon.readingcloud.homepage.controller;

import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.IndexBooklistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书单图书接口
 * @author: zealon
 * @since: 2020/4/8
 */
//"精品页书单图书接口")
@RestController
public class IndexBooklistItemController {

    @Autowired
    private IndexBooklistItemService indexBooklistItemService;

//"书单更多分页接口", httpMethod = "GET")
    @GetMapping("index/getBooklistPagingBooks")
    public Result getBooklistPagingBooks(Integer booklistId, Integer page, Integer limit){
        return this.indexBooklistItemService.getBooklistPagingBooks(booklistId, page, limit);
    }

//"书单换一换接口", httpMethod = "GET")
    @GetMapping("index/getBooklistExchange")
    public Result getBooklistExchange(Integer booklistId, Integer clientRandomNumber) {
        return this.indexBooklistItemService.getBooklistExchange(booklistId, clientRandomNumber);
    }
}
