package org.bearer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MI
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.bearer.mapper"})
@EnableTransactionManagement
public class BearerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BearerApplication.class, args);
    }
}
