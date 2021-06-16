package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.po.ArticleCollection;
import org.bearer.entity.vo.Article;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:44
 */
@Mapper
public interface ArticleCollectionMapper {
    /**
     * 获取收藏文章
     *
     * @param userId 用户id
     * @return List<Article>
     */
    List<Article> selectList(String userId);

    /**
     * 保存收藏的文章
     *
     * @param articleCollection 收藏信息
     * @return int
     */
    int insertCollection(ArticleCollection articleCollection);

    /**
     * 删除收藏文章
     *
     * @param articleId 文章id
     * @param userId 用户id
     * @return int
     */
    int deleteCollection(String articleId, String userId);
}
