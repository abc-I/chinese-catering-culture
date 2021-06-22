package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.ArticleCollection;
import org.bearer.entity.vo.ArticleVO;
import org.bearer.entity.vo.Page;
import org.bearer.mapper.ArticleCollectionMapper;
import org.bearer.service.ArticleCollectionService;
import org.bearer.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/11 13:33
 */
@Service
public class ArticleCollectionServiceImpl implements ArticleCollectionService {

    /**
     * 文章收藏 mapper
     */
    @Resource
    private ArticleCollectionMapper articleCollectionMapper;

    /**
     * 通过用户id获取收藏文章
     *
     * @param userId 用户id
     * @param currentPage 当前页
     * @param pageSize 每页几条
     * @return List<Article>
     */
    @Override
    public Page getCollection(String userId, int currentPage, int pageSize) {
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<ArticleVO> articles = articleCollectionMapper.selectList(userId, start, end);

        int total = articleCollectionMapper.selectCountById(userId);

        return new Page(total, PageUtil.getPageCount(total, pageSize), articles);
    }

    /**
     * 操作收藏的文章
     *
     * @param ids JSON{"id":"收藏文章id","userId":"用户id"}
     * @return int
     */
    @Override
    public int collection(Ids ids) {
        String id = UUID.randomUUID().toString().replace("-", "");
        ArticleCollection articleCollection =
                new ArticleCollection(id, ids.getUserId(), ids.getId());

        String collectionId = articleCollectionMapper.selectIdByUserId(ids);

        if (collectionId != null) {
            return articleCollectionMapper.deleteCollection(ids);
        } else {
            return articleCollectionMapper.insertCollection(articleCollection);
        }
    }
}
