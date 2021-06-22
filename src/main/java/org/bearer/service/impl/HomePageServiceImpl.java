package org.bearer.service.impl;

import org.bearer.entity.po.BrowsingHistory;
import org.bearer.entity.vo.*;
import org.bearer.mapper.*;
import org.bearer.service.HomePageService;
import org.bearer.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/9 19:50
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class HomePageServiceImpl implements HomePageService {

    /**
     * 菜系分类 mapper
     */
    @Resource
    private CuisineMapper cuisineMapper;

    /**
     * 轮播图 mapper
     */
    @Resource
    private CarouselMapper carouselMapper;

    /**
     * 文章 mapper
     */
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 视频 mapper
     */
    @Resource
    private VideoMapper videoMapper;

    /**
     * 历史记录 mapper
     */
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;

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
     * @param end   区间结尾
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
     * @param end   区间结尾
     * @return List<Article>
     */
    @Override
    public List<ArticleVO> getArticleRecommend(int start, int end) {
        return articleMapper.selectList(start, end);
    }

    /**
     * 通过文章id获取文章
     *
     * @param id     文章id
     * @param userId 用户id
     * @return org.bearer.entity.vo.Article
     */
    @Override
    public ArticleVO getArticle(String id, String userId) {
        ArticleVO article = articleMapper.selectOne(id);

        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setId(UUID.randomUUID().toString());
        browsingHistory.setArticleId(id);
        browsingHistory.setUserId(userId);

        browsingHistoryMapper.insertArticleHistory(browsingHistory);
        articleMapper.updateRecommend(id);
        return article;
    }

    /**
     * 通过视频id获取视频
     *
     * @param id     视频id
     * @param userId 用户id
     * @return org.bearer.vo.Video
     */
    @Override
    public VideoVO getVideo(String id, String userId) {
        VideoVO video = videoMapper.selectOne(id);

        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setId(UUID.randomUUID().toString());
        browsingHistory.setVideoId(id);
        browsingHistory.setUserId(userId);

        browsingHistoryMapper.insertVideoHistory(browsingHistory);
        videoMapper.updateRecommend(id);
        return video;
    }

    /**
     * 通过菜系id获取文章
     *
     * @param id 菜系分类文章
     * @return org.bearer.entity.vo.Page
     */
    @Override
    public Page getArticleByCuisine(String id, int currentPage, int pageSize) {
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<ArticleVO> articles = articleMapper.selectByCuisine(id, start, end);

        int total = articleMapper.selectCountByCuisine(id);

        return new Page(total, PageUtil.getPageCount(total, pageSize), articles);
    }

    /**
     * 通过菜系分类获取视频
     *
     * @param id          菜系分类id
     * @param currentPage 当前页
     * @param pageSize    每页几条数据
     * @return org.bearer.entity.vo.Page
     */
    @Override
    public Page getVideoByCuisine(String id, int currentPage, int pageSize) {
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<VideoVO> videos = videoMapper.selectByCuisine(id, start, end);

        int total = videoMapper.selectCountByCuisine(id);

        return new Page(total, PageUtil.getPageCount(total, pageSize), videos);
    }
}
