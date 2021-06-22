package org.bearer.service;

import org.bearer.entity.vo.*;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/9 19:48
 */
public interface HomePageService {

    /**
     * 获取所有菜系
     *
     * @return List<Cuisine>
     */
    List<Cuisine> getCuisine();

    /**
     * 获取一定区间内的图片作为轮播图
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Carousel>
     */
    List<Carousel> getCarousel(int start,int end);

    /**
     * 获取一定区间内的推荐文章
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Article>
     */
    List<ArticleVO> getArticleRecommend(int start, int end);

    /**
     * 通过文章id获取文章
     *
     * @param id 文章id
     * @param userId 用户id
     * @return org.bearer.entity.vo.Article
     */
    ArticleVO getArticle(String id, String userId);

    /**
     * 通过视频id获取视频
     *
     * @param id 视频id
     * @param userId 用户id
     * @return org.bearer.vo.Video
     */
    VideoVO getVideo(String id, String userId);

    /**
     * 通过菜系分类获取文章
     *
     * @param id 菜系分类id
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return org.bearer.entity.vo.Page
     */
    Page getArticleByCuisine(String id, int currentPage, int pageSize);

    /**
     * 通过菜系分类获取视频
     *
     * @param id 菜系分类id
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return org.bearer.entity.vo.Page
     */
    Page getVideoByCuisine(String id, int currentPage, int pageSize);
}
