package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.UserLogin;
import org.bearer.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:20
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 微信登录
     *
     * @param userLogin 取appId，secret，js_code
     * @return org.bearer.entity.Result
     */
    @PostMapping("/weChatLogin")
    public Result weChatLogin(@RequestBody UserLogin userLogin) {
        return loginService.weChatLogin(userLogin);
    }

    /**
     * 管理员登录
     *
     * @param userLogin 取account，password
     * @return org.bearer.entity.Result
     */
    @PostMapping("/adminLogin")
    public Result adminLogin(@RequestBody UserLogin userLogin) {
        return loginService.adminLogin(userLogin);
    }
}