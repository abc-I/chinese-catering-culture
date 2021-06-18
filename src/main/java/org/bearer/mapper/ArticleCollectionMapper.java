package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
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
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Article>
     */
    List<Article> selectList(String userId, int start, int end);

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
     * @param ids 文章用户id
     * @return int
     */
    int deleteCollection(Ids ids);

    /**
     * 通过userId统计收藏的文章数
     *
     * @param userId 用户id
     * @return 总条数
     */
    int selectCountById(String userId);
}
