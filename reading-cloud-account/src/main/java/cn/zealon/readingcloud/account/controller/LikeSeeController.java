package cn.zealon.readingcloud.account.controller;

import cn.zealon.readingcloud.account.service.UserLikeSeeService;
import cn.zealon.readingcloud.common.request.RequestParams;
import cn.zealon.readingcloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 喜欢看接口
 * @author: zealon
 * @since: 2020/4/14
 */
//"喜欢看"
@RestController
@RequestMapping("account/like-see")
public class LikeSeeController {

    @Autowired
    private UserLikeSeeService userLikeSeeService;

    //"用户喜欢点击接口", httpMethod = "POST")
    @PostMapping("/click")
    public Result likeSeeClick(@RequestHeader("userId") Integer userId, @RequestBody RequestParams params) {
        String bookId = params.getStringValue("bookId");
        Integer value = params.getIntValue("value");
        return this.userLikeSeeService.likeSeeClick(userId, bookId, value);
    }

    //"获取图书喜欢总数", httpMethod = "GET")
    @GetMapping("/get-count")
    public Result<Integer> getBookLikesCount(String bookId) {
        return this.userLikeSeeService.getBookLikesCount(bookId);
    }

    //"获取用户喜欢书单", httpMethod = "GET")
    @GetMapping("/get-books")
    public Result getUserLikeBookList(@RequestHeader("userId") Integer userId, Integer page, Integer limit) {
        return this.userLikeSeeService.getUserLikeBookList(userId, page, limit);
    }

    //用户是否喜欢此书", httpMethod = "GET")
    @GetMapping("/exist-book")
    public Result<Integer> userLikeThisBook(@RequestHeader("userId") Integer userId, String bookId) {
        return this.userLikeSeeService.userLikeThisBook(userId, bookId);
    }
}