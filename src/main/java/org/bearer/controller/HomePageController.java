package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.Carousel;
import org.bearer.entity.vo.Cuisine;
import org.bearer.entity.vo.Video;
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
        List<Article> articles = homePageService.getArticleRecommend(start, end);
        return Result.result200(articles);
    }

    /**
     * 获取区间内的视频
     *
     * @param start 区间开始
     * @param end   区间结尾
     * @return org.bearer.entity.Result
     */
    @GetMapping("/videoRecommend/{start}/{end}")
    public Result getVideoRecommend(@PathVariable int start, @PathVariable int end) {
        List<Video> videos = homePageService.getVideoRecommend(start, end);
        return Result.result200(videos);
    }

    /**
     * 获取单个文章
     *
     * @param id 文章id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/article/{id}")
    public Result getArticle(@PathVariable String id) {
        Article article = homePageService.getArticle(id);
        return Result.result200(article);
    }

    /**
     * 获取单个视频
     *
     * @param id 视频id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/video/{id}")
    public Result getVideo(@PathVariable String id) {
        Video video = homePageService.getVideo(id);
        return Result.result200(video);
    }
}