package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.vo.Page;
import org.bearer.service.PersonalPageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 10:39 PM
 */
@RestController
@RequiresRoles(value = {"user", "admin"}, logical = Logical.OR)
@RequestMapping(value = "/personal")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class PersonalPageController {

    @Resource
    private PersonalPageService personalService;

    /**
     * get the list of self articles
     *
     * @param userId
     * @return Result contain List<Article>
     */
    @GetMapping(value = "/selfArticle/{userId}/{currentPage}/{pageSize}")
    public Result getSelfArticle(@PathVariable String userId,
                                 @PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = personalService.getSelfArticle(userId, currentPage, pageSize);
        return Result.result200(page);
    }

    @GetMapping(value = "/browsingHistory/{userId}/{currentPage}/{pageSize}")
    public Result getBrowsingHistory(@PathVariable String userId,
                                     @PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = personalService.getBrowsingHistory(userId, currentPage, pageSize);
        return Result.result200(page);
    }
}
