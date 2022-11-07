package cn.zealon.readingcloud.homepage.controller;

import cn.zealon.readingcloud.book.feign.client.BookClient;
import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.IndexPageConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 精品页接口
 * @author: zealon
 * @since: 2020/4/8
 */
//"精品页接口")
@RestController
public class IndexPageConfigController {

    @Autowired
    private IndexPageConfigService indexPageConfigService;

//    @Autowired
//    BookClient bookClient;

    @Autowired
    RabbitTemplate rabbitTemplate;
//"获取精品页接口", httpMethod = "GET")
    @GetMapping("/index")
    public Result getIndexPageByType(Integer type, Integer page, Integer limit){
        return this.indexPageConfigService.getIndexPageByType(type, page, limit);
    }
//    @GetMapping("/test")
//    public int test(){
//        System.out.print(3);
//        return bookClient.test();
//    }
}
