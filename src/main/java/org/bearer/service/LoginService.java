package org.bearer.service;

import org.bearer.entity.Result;
import org.bearer.entity.dto.ChatLogin;
import org.bearer.entity.dto.Login;
import org.bearer.entity.dto.SignUp;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:43
 */
public interface LoginService {
    /**
     * 微信登录
     *
     * @param userLogin 取appId，secret，js_code
     * @return org.bearer.entity.Result
     */
    Result weChatLogin(ChatLogin userLogin);

    /**
     * 管理员登录
     *
     * @param userLogin 取account，password
     * @return org.bearer.entity.Result
     */
    Result adminLogin(Login userLogin);

    /**
     * 等出
     *
     * @param request 请求对象
     * @return org.bearer.entity.Result
     */
    Result logout(HttpServletRequest request);

    /**
     * 注册管理员用户
     *
     * @param signUp JSON{"username":"用户名","password":"密码"}
     * @return Result
     */
    Result signUp(SignUp signUp);
}
