package org.bearer.service;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Article;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/11 13:32
 */
public interface ArticleCollectionService {

    /**
     * 获取收藏文章
     *
     * @param userId 用户id
     * @return List<Article>
     */
    List<Article> getCollection(String userId);

    /**
     * 保存收藏的文章
     *
     * @param ids JSON{"articleId":"收藏文章id","userId":"用户id"}
     * @return int
     */
    int insertCollection(Ids ids);

    /**
     * 删除收藏文章
     *
     * @param ids JSON{"articleId":"收藏文章id","userId":"用户id"}
     * @return int
     */
    int deleteCollection(Ids ids);
}
