package org.bearer.service;

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
}
