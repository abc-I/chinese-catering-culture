package org.bearer;

import org.bearer.util.JedisUtil;
import org.bearer.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class BearerApplicationTests {

    @Test
    void contextLoads() {
        Jedis jedis = JedisUtil.getJedis();
//        jedis.auth("LiZhanFeng,341.");
        System.out.println(jedis.ping());
    }

}
