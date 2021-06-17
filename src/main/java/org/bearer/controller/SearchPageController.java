package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.SearchRecordsDTO;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.DishName;
import org.bearer.entity.vo.Material;
import org.bearer.entity.vo.Video;
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
        List<DishName> dishName = searchPageService.getDishName(id);
        return Result.result200(dishName);
    }

    /**
     * fuzzy search by key word of main material
     * @author fanyuhongzhe
     * @param userId
     * @param searchContent
     * @return Result contains the search result of the request
     */
    @GetMapping("/article/{userId}/{searchContent}")
    public Result getArticles(@PathVariable String userId, @PathVariable String searchContent) {
        List<Article> articleSearchList = searchPageService.getArticleSearchResult(userId, searchContent);
        return Result.result200(articleSearchList);
    }

    /**
     * fuzzy search by key word of main material
     * @author fanyuhongzhe
     * @param userId
     * @param searchContent
     * @return Result contains the search result of the request
     */
    @GetMapping("/video/{userId}/{searchContent}")
    public Result getVideos(@PathVariable String userId, @PathVariable String searchContent) {
        List<Video> videoSearchList = searchPageService.getVideoSearchResult(userId, searchContent);
        return Result.result200(videoSearchList);
    }

    /**
     * get search records
     * @param userId
     * @return Result contains the search search records of the user
     */
    @GetMapping("/records/{userId}")
    public Result getSearchRecords(@PathVariable String userId){
        List<String> records = searchPageService.getSearchRecords(userId);
//        List<String> records = searchPageService.getSearchRecords("dijfkfpjfwt806d37k0ur3ahl0t3");
        return Result.result200(records);
    }
}
