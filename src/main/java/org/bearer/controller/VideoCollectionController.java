package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;
import org.bearer.service.VideoCollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:16
 */
@RestController
@RequiresRoles(value = {"user", "admin"}, logical = Logical.OR)
@RequestMapping("/video")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class VideoCollectionController {

    @Resource
    private VideoCollectionService videoCollectionService;

    /**
     * 获取收藏的文章
     *
     * @param userId 用户id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/getCollection/{userId}/{currentPage}/{pageSize}")
    public Result getVideoCollection(@PathVariable String userId,
                                @PathVariable int currentPage, @PathVariable int pageSize) {

        Page page = videoCollectionService.getCollection(userId, currentPage, pageSize);
        return Result.result200(page);
    }

    /**
     * 操作收藏的文章
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/collection")
    public Result videoCollection(@RequestBody Ids ids) {
        int len = videoCollectionService.collection(ids);
        return Result.result200(len);
    }
}
