package org.bearer.service.impl;

import org.bearer.entity.dto.UserLogin;
import org.bearer.entity.po.OpenIdJson;
import org.bearer.service.LoginService;
import org.bearer.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:44
 */
@Service
public class LoginServiceImpl implements LoginService {

    private OpenIdJson openIdJson;

    public void setLoginServiceImpl(OpenIdJson openIdJson) {
        this.openIdJson = openIdJson;
    }


    @Override
    public String weChatLogin(UserLogin login) {
        HashMap<String, String> params = new HashMap<>(4);
        params.put("appid=", login.getAppId());
        params.put("secret=", login.getSecret());
        params.put("js_code=", login.getCode());
        params.put("grant_type", "authorization_code");

        try {
            String result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?", params);
            return result;
//            openIdJson.setOpenId(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

//        return JwtUtil.createJwtToken(openIdJson.getOpenId());
    }
}
