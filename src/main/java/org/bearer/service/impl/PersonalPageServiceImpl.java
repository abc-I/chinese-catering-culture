package org.bearer.service.impl;

import org.bearer.entity.dto.ArticleDTO;
import org.bearer.entity.dto.DishArticleDTO;
import org.bearer.entity.dto.DishVideoDTO;
import org.bearer.entity.dto.VideoDTO;
import org.bearer.entity.po.Article;
import org.bearer.entity.po.DishName;
import org.bearer.entity.po.Video;
import org.bearer.entity.vo.ArticleVO;
import org.bearer.entity.vo.BrowsingHistoryVO;
import org.bearer.entity.vo.Page;
import org.bearer.mapper.*;
import org.bearer.service.PersonalPageService;
import org.bearer.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 10:51 PM
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class PersonalPageServiceImpl implements PersonalPageService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;
    @Resource
    private VideoMapper videoMapper;
    @Resource
    private DishNameMapper dishNameMapper;
    @Resource
    private MaterialNameMapper materialNameMapper;


    /**
     * get the self articles
     *
     * @param authorId
     * @return list of self articles
     */
    @Override
    public Page getSelfArticle(String authorId, int currentPage, int pageSize) {
//        return null;
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<ArticleVO> articles = articleMapper.selectArticleSearchByAuthorId(authorId, start, end);

        int total = articleMapper.selectCountByAuthorId(authorId);

        return new Page(total, PageUtil.getPageCount(total, pageSize), articles);
    }

    /**
     * get user's browsing history
     *
     * @param userId
     * @return list of the BrowsingHistoryVO 可以按时间排序
     * 返回的实体类需要增加时间吗？
     */
    @Override
    public Page getBrowsingHistory(String userId, int currentPage, int pageSize) {
//        return null;
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        HashSet<BrowsingHistoryVO> browsingHistories =
                browsingHistoryMapper.selectArticleHistoryByUserId(userId, start, end);

        browsingHistories.addAll(browsingHistoryMapper.selectVideoHistoryByUserId(userId, start, end));

        int total = browsingHistoryMapper.selectCountByUserId(userId);

        return new Page(total, PageUtil.getPageCount(total, pageSize), browsingHistories);
    }

    /**
     * upload user's article
     *
     * @param articleDTO
     * @return if successful
     */
    @Override
    public Boolean uploadArticle(ArticleDTO articleDTO) {
        return articleMapper.insertArticle(new Article(articleDTO));
    }

    /**
     * upload user's video
     *
     * @param videoDTO
     * @return if successful
     */
    @Override
    public Boolean uploadVideo(VideoDTO videoDTO) {
        return videoMapper.insertVideo(new Video(videoDTO));
    }

    /**
     * upload user's article with dishname
     *
     * @param dishArticleDTO
     * @return if successful
     */
    @Override
    public Boolean uploadDishArticle(DishArticleDTO dishArticleDTO) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        Article article = new Article(dishArticleDTO);
        article.setId(id);

        articleMapper.insertArticle(article);

        DishName dishName = new DishName(dishArticleDTO.getName(), id, null);

        dishNameMapper.insertDishName(dishName);

        return materialNameMapper.insertMaterialName(dishArticleDTO.getMaterialId(), dishName.getId());
    }

    /**
     * upload user's video with dishname
     *
     * @param dishVideoDTO
     * @return if successful
     */
    @Override
    public Boolean uploadDishVideo(DishVideoDTO dishVideoDTO) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        Video video = new Video(dishVideoDTO);
        video.setId(id);

        videoMapper.insertVideo(video);

        DishName dishName = new DishName(dishVideoDTO.getName(), null, id);

        dishNameMapper.insertDishName(dishName);

        return materialNameMapper.insertMaterialName(dishVideoDTO.getMaterialId(), dishName.getId());

    }
}
