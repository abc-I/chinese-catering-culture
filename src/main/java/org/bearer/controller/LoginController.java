package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.dto.ChatLogin;
import org.bearer.entity.dto.Login;
import org.bearer.entity.dto.SignUp;
import org.bearer.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:20
 */
@RestController
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
    public Result weChatLogin(@RequestBody ChatLogin userLogin) {
        return loginService.weChatLogin(userLogin);
    }

    /**
     * 管理员登录
     *
     * @param userLogin 取account，password
     * @return org.bearer.entity.Result
     */
    @PostMapping("/adminLogin")
    public Result adminLogin(@RequestBody Login userLogin) {
        return loginService.adminLogin(userLogin);
    }


    /**
     * 注册管理员用户
     *
     * @param signUp JSON{"username":"用户名","password":"密码"}
     * @return Result
     */
    @PostMapping("/signUp")
    @RequiresRoles(value = {"administrator"})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result signUp(@RequestBody SignUp signUp) {
        return loginService.signUp(signUp);
    }

    /**
     * 等出
     *
     * @param request 请求对象
     * @return org.bearer.entity.Result
     */
    @DeleteMapping("/logout")
    @RequiresRoles(value = {"user", "admin", "administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result logout(HttpServletRequest request) {
        return loginService.logout(request);
    }
}