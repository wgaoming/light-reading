package cn.zealon.readingcloud.homepage.controller;

import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.homepage.service.IndexPageConfigService;
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

//"获取精品页接口", httpMethod = "GET")
    @GetMapping("/index")
    public Result getIndexPageByType(Integer type, Integer page, Integer limit){
        return this.indexPageConfigService.getIndexPageByType(type, page, limit);
    }
}
