package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.ArticleCollection;
import org.bearer.entity.vo.ArticleVO;

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
    List<ArticleVO> selectList(String userId, int start, int end);

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

    /**
     * 通过userId和文章id，获取收藏id
     *
     * @param ids JSON{"id":"收藏文章id","userId":"用户id"}
     * @return String
     */
    String selectIdByUserId(Ids ids);
}
