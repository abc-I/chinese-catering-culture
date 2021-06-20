package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bearer.entity.Result;
import org.bearer.entity.dto.TestDTO;
import org.bearer.mapper.TestMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:31
 */
@RestController
//@Api("test")
public class TestController {

    @Resource
    private TestMapper testMapper;

    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    @ApiOperation("test")
    @PostMapping("/test")
    public Result test(@RequestBody TestDTO testDTO) {
        System.out.println(testDTO);
        return Result.result200("OK");
    }
}
