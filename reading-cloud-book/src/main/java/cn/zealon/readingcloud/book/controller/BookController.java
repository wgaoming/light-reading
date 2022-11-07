package cn.zealon.readingcloud.book.controller;

import cn.zealon.readingcloud.book.service.BookService;
import cn.zealon.readingcloud.book.vo.BookVO;
import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书接口
 * @author: zealon
 * @since: 2019/4/3
 */
//"图书查询接口"
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    //"查询图书基本信息" , httpMethod = "GET"
    @GetMapping("/getBookById")
    public Result<Book> getBookById(String bookId){
        return bookService.getBookById(bookId);
    }

    //"获取图书详情" , httpMethod = "GET")
    @GetMapping("/details")
    public Result<BookVO> getBookDetails(String bookId){
        return bookService.getBookDetails(bookId);
    }
    @GetMapping("/test")
    public int test(){
        return 1;
    }
}