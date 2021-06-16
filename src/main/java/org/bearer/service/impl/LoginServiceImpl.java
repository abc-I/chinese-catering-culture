package org.bearer.service.impl;

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

    @Value("login.appId")
    private String appId;

    @Value("login.secret")
    private String secret;

    @Value("login.grant_type")
    private String grantType;

    private OpenIdJson openIdJson;

    public void setLoginServiceImpl(OpenIdJson openIdJson) {
        this.openIdJson = openIdJson;
    }


    @Override
    public String weChatLogin(String code) {
        HashMap<String, String> params = new HashMap<>(4);
        params.put("appid=", appId);
        params.put("secret=", secret);
        params.put("js_code=", "003uVK0w3Md5zW2O0V0w3L9oR60uVK06");
        params.put("grant_type", grantType);

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
