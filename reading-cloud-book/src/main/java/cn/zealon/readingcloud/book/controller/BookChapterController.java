package cn.zealon.readingcloud.book.controller;
import cn.zealon.readingcloud.book.service.BookChapterService;
import cn.zealon.readingcloud.book.vo.BookChapterReadVO;
import cn.zealon.readingcloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书章节接口
 * @author: zealon
 * @since: 2019/9/25
 */
//"章节查询接口")
@RestController
@RequestMapping("book/chapter")
public class BookChapterController {

    @Autowired
    private BookChapterService bookChapterService;

//"查询图书章节基本信息" , httpMethod = "GET")
    @RequestMapping("/getChapter")
    public Result getChapter(String bookId, Integer chapterId){
        return bookChapterService.getChapterById(bookId, chapterId);
    }

//"查询图书章节列表信息" , httpMethod = "GET")
    @RequestMapping("/getChapterList")
    public Result getBookChapterList(String bookId) {
        return this.bookChapterService.getBookChapterListByBookId(bookId);
    }

//"阅读内容" , httpMethod = "GET")
    @RequestMapping("/readChapter")
    public Result<BookChapterReadVO> readChapter(String bookId, Integer chapterId){
        return this.bookChapterService.readChapter(bookId, chapterId);
    }
}
