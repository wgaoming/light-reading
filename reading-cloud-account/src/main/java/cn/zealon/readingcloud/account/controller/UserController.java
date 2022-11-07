package cn.zealon.readingcloud.account.controller;

import cn.zealon.readingcloud.account.bo.UserBO;
import cn.zealon.readingcloud.account.service.UserService;
import cn.zealon.readingcloud.account.vo.AuthVO;
import cn.zealon.readingcloud.common.request.RequestParams;
import cn.zealon.readingcloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * @author: zealon
 * @since: 2020/4/11
 */
//"用户服务接口")
@RestController
@RequestMapping("account/user")
public class UserController {

    @Autowired
    private UserService userService;

//"注册用户", httpMethod = "POST")
    @PostMapping("/register")
    public Result register(@RequestBody UserBO userBO) {
        return this.userService.register(userBO);
    }

//用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public Result<AuthVO> login(@RequestBody RequestParams params) {
        String loginName = params.getStringValue("loginName");
        String password = params.getStringValue("password");
        return this.userService.login(loginName, password);
    }

    @GetMapping("/test")
    public int test(){
        return 1;
    }
}