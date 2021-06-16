package org.bearer.service;

import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.BrowsingHistory;

import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 10:50 PM
 */
public interface PersonalPageService {
    /**
     * get the self articles
     * @param authorId
     * @return list of self articles
     */
    List<Article> getSelfArticle(String authorId);

    /**
     * get user's browsing history
     * @param userId
     * @return list of the BrowsingHistory
     */
    List<BrowsingHistory> getBrowsingHistory(String userId);
}
