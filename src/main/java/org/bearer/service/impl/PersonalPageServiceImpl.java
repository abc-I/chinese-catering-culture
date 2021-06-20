package org.bearer.service.impl;

import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.BrowsingHistoryVO;
import org.bearer.entity.vo.Page;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.BrowsingHistoryMapper;
import org.bearer.service.PersonalPageService;
import org.bearer.util.PageUtil;
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
    public Page getSelfArticle(String authorId, int currentPage, int pageSize) {
//        return null;
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<Article> articles = articleMapper.selectArticleSearchByAuthorId(authorId, start, end);

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

        List<BrowsingHistoryVO> browsingHistories =
                browsingHistoryMapper.selectBrowsingHistoryByUserId(userId, start, end);

        int total = browsingHistoryMapper.selectCountByUserId(userId);

        return new Page(total, PageUtil.getPageCount(total, pageSize), browsingHistories);
    }
}
