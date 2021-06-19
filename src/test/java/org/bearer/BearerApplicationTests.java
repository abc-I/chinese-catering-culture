package org.bearer;

import org.bearer.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BearerApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(MD5Util.parse("administrator", "administrator"));
    }

}
