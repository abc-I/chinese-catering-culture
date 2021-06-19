package org.bearer.service;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.Page;
import org.springframework.web.bind.annotation.PathVariable;

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
    Page getCollection(String userId, int currentPage, int pageSize);

    /**
     * 操作收藏的文章
     *
     * @param ids JSON{"id":"收藏文章id","userId":"用户id"}
     * @return int
     */
    int collection(Ids ids);
}
