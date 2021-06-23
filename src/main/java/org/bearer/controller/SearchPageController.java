package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.vo.*;
import org.bearer.service.SearchPageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fanyuhongzhe
 * @description search module
 * @date 6/10/21 1:45 PM
 */
@RestController
@RequestMapping(value = "/search")
public class SearchPageController {

    @Resource
    private SearchPageService searchPageService;

    /**
     * get the main material list
     * @author fanyuhongzhe
     * @return Result contains the all main List<String> material
     */
    @GetMapping("/material")
    public Result getMaterial() {
        List<Material> materials = searchPageService.getMaterial();
        return Result.result200(materials);
    }

    /**
     * get dish name
     * @author fanyuhongzhe
     * @param id
     * @return Result contains list of dish name
     */
    @GetMapping("/dish/{id}")
    public Result getDishName(@PathVariable String id) {
        List<DishNameVO> dishName = searchPageService.getDishName(id);
        return Result.result200(dishName);
    }

    /**
     * fuzzy search by key word of main material
     *
     * @param userId
     * @param searchContent
     * @return Result contains the search result of the request
     * @author fanyuhongzhe
     */
    @GetMapping("/article/{userId}/{searchContent}/{currentPage}/{pageSize}")
    public Result getArticles(@PathVariable String userId, @PathVariable String searchContent,
                              @PathVariable int currentPage, @PathVariable int pageSize) {

        Page page = searchPageService.getArticleSearchResult(userId, searchContent,
                currentPage, pageSize);

        return Result.result200(page);
    }

    /**
     * fuzzy search by key word of main material
     *
     * @param userId
     * @param searchContent
     * @return Result contains the search result of the request
     * @author fanyuhongzhe
     */
    @GetMapping("/video/{userId}/{searchContent}/{currentPage}/{pageSize}")
    public Result getVideos(@PathVariable String userId, @PathVariable String searchContent,
                            @PathVariable int currentPage, @PathVariable int pageSize) {

        Page page = searchPageService.getVideoSearchResult(userId, searchContent, currentPage, pageSize);
        return Result.result200(page);
    }

    /**
     * get search records
     *
     * @param userId
     * @return Result contains the search search records of the user
     */
    @RequiresRoles(value = {"admin", "user"}, logical = Logical.OR)
    @GetMapping("/records/{userId}")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result getSearchRecords(@PathVariable String userId) {
        List<String> records = searchPageService.getSearchRecords(userId);
//        List<String> records = searchPageService.getSearchRecords("dijfkfpjfwt806d37k0ur3ahl0t3");
        return Result.result200(records);
    }
}
