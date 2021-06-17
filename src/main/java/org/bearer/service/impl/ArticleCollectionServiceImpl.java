package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.ArticleCollection;
import org.bearer.entity.vo.Article;
import org.bearer.mapper.ArticleCollectionMapper;
import org.bearer.service.ArticleCollectionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/11 13:33
 */
@Service
public class ArticleCollectionServiceImpl implements ArticleCollectionService {

    private final ArticleCollectionMapper articleCollectionMapper;

    public ArticleCollectionServiceImpl(ArticleCollectionMapper articleCollectionMapper) {
        this.articleCollectionMapper = articleCollectionMapper;
    }

    /**
     * 获取收藏文章
     *
     * @param userId 用户id
     * @return List<Article>
     */
    @Override
    public List<Article> getCollection(String userId) {
        return articleCollectionMapper.selectList(userId);
    }

    /**
     * 保存收藏的文章
     *
     * @param ids JSON{"id":"收藏文章id","userId":"用户id"}
     * @return int
     */
    @Override
    public int insertCollection(Ids ids) {
        String id = UUID.randomUUID().toString().replace("-", "");
        ArticleCollection articleCollection =
                new ArticleCollection(id, ids.getUserId(), ids.getId());
        return articleCollectionMapper.insertCollection(articleCollection);
    }

    /**
     * 删除收藏文章
     *
     * @param ids JSON{"articleId":"收藏文章id","userId":"用户id"}
     * @return int
     */
    @Override
    public int deleteCollection(Ids ids) {
        return articleCollectionMapper.deleteCollection(ids);
    }
}
