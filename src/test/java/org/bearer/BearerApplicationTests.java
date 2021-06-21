package org.bearer;

import org.bearer.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class BearerApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(MD5Util.parse("admin", "admin"));

    }

}
