package org.bearer.controller;

import org.bearer.mapper.TestMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:31
 */
@RestController
public class TestController {

    private final TestMapper testMapper;

    public TestController(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @GetMapping("/test/{id}")
    public void test(@PathVariable String id) {
        testMapper.get();
        System.out.println("a");
    }
}
