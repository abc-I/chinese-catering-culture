package org.bearer.service.impl;

import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.BrowsingHistory;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.BrowsingHistoryMapper;
import org.bearer.service.PersonalPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 10:51 PM
 */
@Service
public class PersonalPageServiceImpl implements PersonalPageService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;

    /**
     * get the self articles
     *
     * @param authorId
     * @return list of self articles
     */
    @Override
    public List<Article> getSelfArticle(String authorId) {
//        return null;
        return articleMapper.selectArticleSearchByAuthorId(authorId);
    }

    /**
     * get user's browsing history
     *
     * @param userId
     * @return list of the BrowsingHistory 可以按时间排序
     * 返回的实体类需要增加时间吗？
     */
    @Override
    public List<BrowsingHistory> getBrowsingHistory(String userId) {
//        return null;
        return browsingHistoryMapper.selectBrowsingHistoryByUserId(userId);
    }
}
