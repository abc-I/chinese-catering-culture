package org.bearer.service;

import org.bearer.entity.dto.ArticleDTO;
import org.bearer.entity.dto.DishArticleDTO;
import org.bearer.entity.dto.DishVideoDTO;
import org.bearer.entity.dto.VideoDTO;
import org.bearer.entity.po.Article;
import org.bearer.entity.vo.Page;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 10:50 PM
 */
public interface PersonalPageService {
    /**
     * get the self articles
     *
     * @param authorId
     * @return list of self articles
     */
    Page getSelfArticle(String authorId, int currentPage, int pageSize);

    /**
     * get user's browsing history
     *
     * @param userId
     * @return list of the BrowsingHistoryVO
     */
    Page getBrowsingHistory(String userId, int currentPage, int pageSize);

    /**
     * upload user's article
     * @param article
     * @return if successful
     */
    Boolean uploadArticle(ArticleDTO article);

    /**
     * upload user's video
     * @param videoDTO
     * @return if successful
     */
    Boolean uploadVideo(VideoDTO videoDTO);

    /**
     * upload user's article with dishname
     * @param dishArticleDTO
     * @return if successful
     */
    Boolean uploadDishArticle(DishArticleDTO dishArticleDTO);

    /**
     * upload user's video with dishname
     * @param dishVideoDTO
     * @return if successful
     */
    Boolean uploadDishVideo(DishVideoDTO dishVideoDTO);
}
