package org.bearer.service;

import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.Carousel;
import org.bearer.entity.vo.Cuisine;
import org.bearer.entity.vo.Video;

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
    List<Article> getArticleRecommend(int start, int end);

    /**
     * 获取一定区间内的推荐视频
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Video>
     */
    List<Video> getVideoRecommend(int start, int end);

    /**
     * 通过文章id获取文章
     *
     * @param id 文章id
     * @return org.bearer.entity.vo.Article
     */
    Article getArticle(String id);

    /**
     * 通过视频id获取视频
     *
     * @param id 视频id
     * @return org.bearer.vo.Video
     */
    Video getVideo(String id);
}
