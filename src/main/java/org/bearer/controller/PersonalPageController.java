package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.dto.ArticleDTO;
import org.bearer.entity.dto.DishArticleDTO;
import org.bearer.entity.dto.DishVideoDTO;
import org.bearer.entity.dto.VideoDTO;
import org.bearer.entity.po.Article;
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

    /**
     * upload article
     * @param article
     * @return Result contains if successful
     */
    @PostMapping(value = "/uploadArticle")
    public Result uploadArticle(@RequestBody ArticleDTO article) {
        return Result.result200(personalService.uploadArticle(article));
    }

    /**
     * upload video
     * @param videoDTO
     * @return Result contains if successful
     */
    @PostMapping(value = "/uploadVideo")
    public Result uploadVideo(@RequestBody VideoDTO videoDTO) {
        return Result.result200(personalService.uploadVideo(videoDTO));
    }

    /**
     * upload article with dishname
     * @param dishArticleDTO
     * @return Result contains if successful
     */
    @PostMapping(value = "/uploadDishArticle")
    public Result uploadDishArticle(@RequestBody DishArticleDTO dishArticleDTO) {
        return Result.result200(personalService.uploadDishArticle(dishArticleDTO));
    }

    /**
     * upload video wish dishname
     * @param dishVideoDTO
     * @return Result contains if successful
     */
    @PostMapping(value = "/uploadDishVideo")
    public Result uploadDishVideo(@RequestBody DishVideoDTO dishVideoDTO) {
        return Result.result200(personalService.uploadDishVideo(dishVideoDTO));
    }
}
