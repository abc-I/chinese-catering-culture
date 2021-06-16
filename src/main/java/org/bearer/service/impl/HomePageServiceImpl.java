package org.bearer.service.impl;

import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.Carousel;
import org.bearer.entity.vo.Cuisine;
import org.bearer.entity.vo.Video;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.CarouselMapper;
import org.bearer.mapper.CuisineMapper;
import org.bearer.mapper.VideoMapper;
import org.bearer.service.HomePageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/9 19:50
 */
@Service
public class HomePageServiceImpl implements HomePageService {

    /**
     * 菜系分类Mapper
     */
    private final CuisineMapper cuisineMapper;

    /**
     * 轮播图Mapper
     */
    private final CarouselMapper carouselMapper;

    /**
     * 文章Mapper
     */
    private final ArticleMapper articleMapper;

    /**
     * 视频Mapper
     */
    private final VideoMapper videoMapper;

    public HomePageServiceImpl(CuisineMapper cuisineMapper, CarouselMapper carouselMapper,
                               ArticleMapper articleMapper, VideoMapper videoMapper) {
        this.cuisineMapper = cuisineMapper;
        this.carouselMapper = carouselMapper;
        this.articleMapper = articleMapper;
        this.videoMapper = videoMapper;
    }

    /**
     * 获取所有菜系
     *
     * @return List<Cuisine>
     */
    @Override
    public List<Cuisine> getCuisine() {
        return cuisineMapper.selectAll();
    }

    /**
     * 获取一定区间内的图片作为轮播图
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Carousel>
     */
    @Override
    public List<Carousel> getCarousel(int start, int end) {
        return carouselMapper.selectList(start, end);
    }

    /**
     * 获取一定区间内的推荐文章
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Article>
     */
    @Override
    public List<Article> getArticleRecommend(int start, int end) {
        return articleMapper.selectList(start, end);
    }

    /**
     * 获取一定区间内的推荐视频
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Video>
     */
    @Override
    public List<Video> getVideoRecommend(int start, int end) {
        return videoMapper.selectList(start, end);
    }

    /**
     * 通过文章id获取文章
     *
     * @param id 文章id
     * @return org.bearer.entity.vo.Article
     */
    @Override
    public Article getArticle(String id) {
        return articleMapper.selectOne(id);
    }

    /**
     * 通过视频id获取视频
     *
     * @param id 视频id
     * @return org.bearer.vo.Video
     */
    @Override
    public Video getVideo(String id) {
        return videoMapper.selectOne(id);
    }
}
