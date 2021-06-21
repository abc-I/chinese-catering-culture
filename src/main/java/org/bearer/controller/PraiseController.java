package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.dto.PostId;
import org.bearer.service.PraiseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:40
 */
@RestController
@RequiresRoles(value = {"user", "admin"}, logical = Logical.OR)
@RequestMapping("/praise")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class PraiseController {

    @Resource
    private PraiseService praiseService;

    /**
     * 保存文章点赞
     *
     * @param id JSON{"id":"文章id"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertArticlePraise")
    public Result insertArticlePraise(@RequestBody PostId id) {
        int len = praiseService.insertArticlePraise(id);
        return Result.result200(len);
    }

    /**
     * 保存视频点赞
     *
     * @param id JSON{"id":"视频id"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertVideoPraise")
    public Result insertVideoPraise(@RequestBody PostId id) {
        int len = praiseService.insertVideoPraise(id);
        return Result.result200(len);
    }
}
