package org.bearer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author MI
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.bearer.mapper"})
public class BearerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BearerApplication.class, args);
    }
}
