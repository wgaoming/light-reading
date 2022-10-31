package cn.zealon.readingcloud.homepage.controller;

import cn.zealon.readingcloud.book.feign.client.BookClient;
import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.IndexPageConfigService;
import io.swagger.annotations.*;
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
@Api(description = "精品页接口")
@RestController
public class IndexPageConfigController {

    @Autowired
    private IndexPageConfigService indexPageConfigService;

    @Autowired
    BookClient bookClient;

    @Autowired
    RabbitTemplate rabbitTemplate;
    @ApiOperation(value = "获取精品页接口", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "type", value = "类型：1.主页，2.男生，3.女生", required = true, dataType = "Integer"),
        @ApiImplicitParam(paramType = "query", name = "page", value = "页数", required = true, dataType = "Integer"),
        @ApiImplicitParam(paramType = "query", name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @ApiResponses({@ApiResponse(code = 200, message = "", response = String.class)})
    @GetMapping("/index")
    public Result getIndexPageByType(Integer type, Integer page, Integer limit){
        return this.indexPageConfigService.getIndexPageByType(type, page, limit);
    }
    @Test
    public void test(){
        System.out.println(rabbitTemplate);
        rabbitTemplate.convertAndSend("test","key","你好");
    }
}
