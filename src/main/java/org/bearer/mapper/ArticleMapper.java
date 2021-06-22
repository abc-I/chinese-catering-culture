package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.PostId;
import org.bearer.entity.po.Article;
import org.bearer.entity.vo.ArticleVO;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:42
 */
@Mapper
public interface ArticleMapper {

    /**
     * 通过文章点击率排序，选择一定区间内的文章
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Article>
     */
    List<ArticleVO> selectList(int start, int end);

    /**
     * 通过文章id获取文章信息
     *
     * @param id 文章id
     * @return org.bearer.entity.vo.Article
     */
    ArticleVO selectOne(String id);

    /**
     * 通过标题查询文章(模糊查询)
     *
     * @param searchContent 查询信息
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Article>
     */
    List<ArticleVO> selectArticleSearchByTitle(String searchContent, int start, int end);

    /**
     * 通过作者id查询文章
     *
     * @param authorId 作者id
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Article>
     */
    List<ArticleVO> selectArticleSearchByAuthorId(String authorId, int start, int end);

    /**
     * 通过文章id删除文章
     *
     * @param id 文章id
     * @return Boolean
     */
    Boolean deleteById(String id);

    /**
     * 通过文章id保存点赞
     *
     * @param id JSON{"id":"文章id"}
     * @return int
     */
    int updatePraise(PostId id);

    /**
     * 查询所有未审核的文章
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Article>
     */
    List<ArticleVO> selectListByIsExamined(int start, int end);

    /**
     * 统计未审核的文章数
     * @return int
     */
    int selectCountNotExamined();

    /**
     * 通过文章id更新审核信息
     *
     * @param id 文章id
     * @return Boolean
     */
    Boolean updateIsExaminedById(String id);

    /**
     * 统计查询结果有几条
     *
     * @param searchContent 查询信息
     * @return int
     */
    int selectCountByTitle(String searchContent);

    /**
     * 添加文章点击次数
     *
     * @param id 文章id
     */
    void updateRecommend(String id);

    /**
     * 通过菜系id获取文章
     *
     * @param id 菜系id
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Article>
     */
    List<ArticleVO> selectByCuisine(String id, int start, int end);

    /**
     * 通过菜系分类统计
     *
     * @param id 菜系分类
     * @return int
     */
    int selectCountByCuisine(String id);

    /**
     * 通过作者id统计文章
     *
     * @param authorId 作者id
     * @return int
     */
    int selectCountByAuthorId(String authorId);

    /**
     * 上传文章
     *
     * @param article JSON{"id":"文章id","title":"文章标题","article":"文章内容",
     *                "pictureUrl":"图片url","authorId":"作者id","cuisineId":"菜系分类id",
     *                "materialId":"主材分类id"}
     * @return Boolean
     */
    Boolean insertArticle(Article article);
}
