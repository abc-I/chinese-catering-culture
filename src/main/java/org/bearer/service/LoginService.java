package org.bearer.service;

import org.bearer.entity.Result;
import org.bearer.entity.dto.ChatLogin;
import org.bearer.entity.dto.Login;

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
}
