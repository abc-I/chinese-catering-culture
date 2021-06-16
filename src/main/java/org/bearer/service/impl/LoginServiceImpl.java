package org.bearer.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.bearer.entity.Result;
import org.bearer.entity.dto.UserLogin;
import org.bearer.entity.po.OpenIdJson;
import org.bearer.entity.po.User;
import org.bearer.mapper.UserMapper;
import org.bearer.service.LoginService;
import org.bearer.util.HttpUtil;
import org.bearer.util.JwtUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:44
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private OpenIdJson openIdJson;

    @Resource(name = "template")
    private RedisTemplate<Serializable,Object> template;

    @Resource
    private UserMapper userMapper;

    @Override
    public String weChatLogin(UserLogin login) {
        HashMap<String, String> params = new HashMap<>(4);
        params.put("appid=", login.getAppId());
        params.put("secret=", login.getSecret());
        params.put("js_code=", login.getCode());
        params.put("grant_type", "authorization_code");

        try {
            String result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?", params);
//            return result;
            openIdJson.setOpenId(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String token = JwtUtil.createJwtToken(openIdJson.getOpenId());



        return token;
    }

    @Override
    public Result adminLogin(UserLogin userLogin) {
        String account = userLogin.getAccount();
        String password = userLogin.getPassword();

        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (UnknownAccountException unknown) {
            throw new UnknownAccountException("账号错误！");
        } catch (LockedAccountException locked) {
            throw new LockedAccountException("账号被锁定！");
        }catch (IncorrectCredentialsException inc){
            throw new IncorrectCredentialsException("密码错误！");
        } catch (AuthenticationException e) {
            throw new AuthenticationException("登录失败！");
        }

        String jwtToken = JwtUtil.createJwtToken(account);

        User user = userMapper.selectOne(account);
        template.opsForValue().set(jwtToken, JSONObject.toJSONString(user), 1000 * 60 * 60 * 24);

        return Result.result200(jwtToken);
    }
}
