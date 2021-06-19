package org.bearer.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.bearer.entity.Result;
import org.bearer.entity.dto.ChatLogin;
import org.bearer.entity.dto.Login;
import org.bearer.entity.pojo.OpenIdJson;
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

    /**
     * redis
     */
    @Resource(name = "template")
    private RedisTemplate<Serializable,Object> template;

    /**
     * 用户 mapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 微信登录
     *
     * @param login 取appId，secret，js_code
     * @return org.bearer.entity.Result
     */
    @Override
    public Result weChatLogin(ChatLogin login) {
        HashMap<String, String> params = new HashMap<>(4);
        params.put("appid=", login.getAppId());
        params.put("secret=", login.getSecret());
        params.put("js_code=", login.getCode());
        params.put("grant_type", "authorization_code");

        OpenIdJson openIdJson;
        try {
            String result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?", params);
            openIdJson = (OpenIdJson) JSONObject.parse(result);
            if (openIdJson != null) {
                String token = JwtUtil.createJwtToken(openIdJson.getOpenId());

                User user = userMapper.selectOne(openIdJson.getOpenId());

                if (user == null) {
                    user = new User();

                    user.setId(openIdJson.getOpenId());
                    user.setAccount(login.getAccount());
                    user.setUsername(login.getUsername());
                    user.setLocked(false);
                    user.setPassword(null);

                    int len = userMapper.insertWeChat(user);
                }
                template.opsForValue().set(token, JSONObject.toJSONString(user), 1000 * 60 * 60 * 24);

                return Result.result200(token);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.result403("拒绝访问！");
    }

    /**
     * 管理员登录
     *
     * @param userLogin 取account，password
     * @return org.bearer.entity.Result
     */
    @Override
    public Result adminLogin(Login userLogin) {
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