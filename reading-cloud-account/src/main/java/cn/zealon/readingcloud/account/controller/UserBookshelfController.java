package cn.zealon.readingcloud.account.controller;

import cn.zealon.readingcloud.account.bo.UserBookshelfBO;
import cn.zealon.readingcloud.account.service.UserBookshelfService;
import cn.zealon.readingcloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 书架接口
 * @author: zealon
 * @since: 2020/4/15
 */
//"用户书架")
@RestController
@RequestMapping("account/bookshelf")
public class UserBookshelfController {

    @Autowired
    private UserBookshelfService bookshelfService;

//"同步书架图书接口", httpMethod = "POST")

    @PostMapping("/sync-book")
    public Result syncUserBookshelf(@RequestHeader("userId") Integer userId, @RequestBody UserBookshelfBO bookshelfBO) {
        return this.bookshelfService.syncUserBookshelf(userId, bookshelfBO);
    }

//"获取书架图书接口", httpMethod = "GET")
    @GetMapping("/get-books")
    public Result getUserBookshelf(@RequestHeader("userId") Integer userId) {
        return this.bookshelfService.getUserBookshelf(userId);
    }

//"用户书架是否存在图书", httpMethod = "GET")
    @GetMapping("/exist-book")
    public Result<Integer> userBookshelfExistBook(@RequestHeader("userId") Integer userId, String bookId) {
        return this.bookshelfService.userBookshelfExistBook(userId, bookId);
    }
}