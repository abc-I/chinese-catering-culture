package org.bearer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/13 21:05
 */
@Component
public class JedisUtil {

    private RedisTemplate<Serializable, Object> redisTemplate;

    @Resource(name = "template")
    public void setJedisUtil(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate<Serializable,Object> getRedisTemplate() {
        System.out.println(redisTemplate);
        return redisTemplate;
    }
}
