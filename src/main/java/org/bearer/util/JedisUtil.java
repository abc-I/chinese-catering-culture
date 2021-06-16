package org.bearer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/13 21:05
 */
@Component
public class JedisUtil {

    @Autowired
    private static RedisTemplate<Serializable, Object> redisTemplate;

    public static RedisTemplate<Serializable,Object> getRedisTemplate() {
        return redisTemplate;
    }
}
