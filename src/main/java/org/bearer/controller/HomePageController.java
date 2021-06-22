package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.vo.*;
import org.bearer.service.HomePageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主页模块控制层
 *
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/9 19:02
 */
@RestController
@RequestMapping(value = "/home")
public class HomePageController {

    /**
     * 主页模块服务层
     */
    @Resource
    private HomePageService homePageService;

    /**
     * 获取所有菜系分类
     *
     * @return org.bearer.entity.Result
     */
    @GetMapping("/cuisine")
    public Result getCuisine() {
        List<Cuisine> cuisines = homePageService.getCuisine();
        return Result.result200(cuisines);
    }

    /**
     * 获取区间内的轮播图
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return org.bearer.entity.Result
     */
    @GetMapping("/carousel/{start}/{end}")
    public Result getCarousel(@PathVariable int start, @PathVariable int end) {
        List<Carousel> carousels = homePageService.getCarousel(start, end);
        return Result.result200(carousels);
    }

    /**
     * 获取区间内的文章
     *
     * @param start 区间开始
     * @param end   区间结尾
     * @return org.bearer.entity.Result
     */
    @GetMapping("/articleRecommend/{start}/{end}")
    public Result getArticleRecommend(@PathVariable int start, @PathVariable int end) {
        List<ArticleVO> articles = homePageService.getArticleRecommend(start, end);
        return Result.result200(articles);
    }

    /**
     * 获取单个文章
     *
     * @param id 文章id
     * @param userId 用户id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/article/{id}/{userId}")
    public Result getArticle(@PathVariable String id, @PathVariable String userId) {
        ArticleVO article = homePageService.getArticle(id, userId);
        return Result.result200(article);
    }

    /**
     * 获取单个视频
     *
     * @param id 视频id
     * @param userId 用户id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/video/{id}/{userId}")
    public Result getVideo(@PathVariable String id, @PathVariable String userId) {
        VideoVO video = homePageService.getVideo(id, userId);
        return Result.result200(video);
    }

    /**
     * 通过菜系分类获取文章
     *
     * @param id 菜系分类id
     * @param currentPage 当前页
     * @param pageSize 每页记录条数
     * @return org.bearer.entity.Result
     */
    @GetMapping("/articleByCuisine/{id}/{currentPage}/{pageSize}")
    public Result getArticleByCuisine(@PathVariable String id,
                                      @PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = homePageService.getArticleByCuisine(id, currentPage, pageSize);
        return Result.result200(page);
    }

    /**
     * 通过菜系分类获取视频
     *
     * @param id 菜系分类id
     * @param currentPage 当前页
     * @param pageSize 每页记录条数
     * @return org.bearer.entity.Result
     */
    @GetMapping("/videoByCuisine/{id}/{currentPage}/{pageSize}")
    public Result getVideoByCuisine(@PathVariable String id,
                                      @PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = homePageService.getVideoByCuisine(id, currentPage, pageSize);
        return Result.result200(page);
    }
}