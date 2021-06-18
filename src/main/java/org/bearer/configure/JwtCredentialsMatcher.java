package org.bearer.configure;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/17 14:50
 */
@Component
public class JwtCredentialsMatcher implements CredentialsMatcher {

    @Resource
    private RedisTemplate<Serializable, Object> template;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String key = (String) authenticationToken.getCredentials();
        Boolean bool = template.hasKey(key);

        if (bool == null || !bool) {
            return false;
        } else {
            template.expire(key, 1000 * 60 * 60 * 24, TimeUnit.MILLISECONDS);
            return true;
        }
    }
}