package org.bearer.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.bearer.entity.Result;
import org.bearer.entity.dto.*;
import org.bearer.entity.pojo.JwtToken;
import org.bearer.entity.pojo.OpenIdJson;
import org.bearer.entity.po.User;
import org.bearer.mapper.UserMapper;
import org.bearer.mapper.UserRoleMapper;
import org.bearer.service.LoginService;
import org.bearer.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:44
 */
@Service
@Transactional(timeout = 5, rollbackFor = {Exception.class})
public class LoginServiceImpl implements LoginService {

    /**
     * 用户 mapper
     */
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

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
        params.put("grant_type=", "authorization_code");

        OpenIdJson openIdJson;
        try {
            String result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?", params);
            try {
                openIdJson = JSONObject.parseObject(result, OpenIdJson.class);
            } catch (ClassCastException e) {
                e.printStackTrace();
                return Result.result401("未通过身份验证");
            }

            if (openIdJson != null) {
                String openId = openIdJson.getOpenId();

                User user = userMapper.selectOne(openId);

                String id;
                if (user == null) {
                    user = new User();
                    UserProfile userProfile = login.getUserProfile();
                    UserInfo userInfo = userProfile.getUserInfo();

                    id = UUID.randomUUID().toString();
                    user.setId(id);
                    user.setAccount(openId);
                    user.setUsername(userInfo.getNickName());
                    user.setLocked(false);

                    userMapper.insertWeChat(user);

                    userRoleMapper.insertRole(id);
                } else {
                    id = user.getId();
                }

                String token = JwtUtil.createJwtToken(id);

                boolean bool = JedisUtil.set(id, token, 1000 * 60 * 60 * 24L);

                if (bool) {
                    return Result.result200(new JwtToken(token));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.result401("登录失败！");
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
        } catch (IncorrectCredentialsException inc) {
            throw new IncorrectCredentialsException("密码错误！");
        } catch (AuthenticationException e) {
            throw new AuthenticationException("登录失败！");
        }

        String id = userMapper.selectIdByAccount(account);

        String jwtToken = JwtUtil.createJwtToken(id);

        boolean bool = JedisUtil.set(id, jwtToken, 1000 * 60 * 60 * 24L);

        if (bool) {
            return Result.result200(new JwtToken(jwtToken));
        } else {
            return Result.result401("登录失败！");
        }
    }

    @Override
    public Result logout(HttpServletRequest request) {
        String key = request.getHeader("JwtToken");

        if (JedisUtil.delete(key)) {
            return Result.result200("success!");
        } else {
            return Result.result500("fail!");
        }
    }
}