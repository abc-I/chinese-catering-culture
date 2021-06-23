package org.bearer.service;

import org.bearer.entity.vo.*;

import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/10/21 2:12 PM
 */
public interface SearchPageService {
    /**
     * get article search result and save the searchRecords
     *
     * @return list of List<ArticleSearch>
     */
    Page getArticleSearchResult(String userId, String searchContent, int currentPage, int pageSize);

    /**
     * get video search result and save the searchRecords
     *
     * @param userId
     * @param searchContent
     * @return list of List<VideoSearch>
     */
    Page getVideoSearchResult(String userId, String searchContent, int currentPage, int pageSize);

    /**
     * get all main material
     * @return all material
     */
    List<Material> getMaterial();

    /**
     * get all dish name by material
     * @return list of dish name
     */
    List<DishNameVO> getDishName(String id);

    /**
     * get user's searchRecords(all now)
     * @param userid
     * @return user's searchRecords
     */
    List<String> getSearchRecords(String userid);
}
