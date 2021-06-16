package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.Article;

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
    List<Article> selectList(int start, int end);

    /**
     * 通过文章id获取文章信息
     *
     * @param id 文章id
     * @return org.bearer.entity.vo.Article
     */
    Article selectOne(String id);

    /**
     * 通过标题查询文章(模糊查询)
     *
     * @param searchContent 查询信息
     * @return List<Article>
     */
    List<Article> selectArticleSearchByTitle(String searchContent);

    List<Article> selectArticleSearchByAuthorId(String authorId);

    Boolean deleteById(String id);
}
