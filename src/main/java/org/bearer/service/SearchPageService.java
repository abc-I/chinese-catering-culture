package org.bearer.service;

import org.bearer.entity.dto.SearchRecordsDTO;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.DishName;
import org.bearer.entity.vo.Material;
import org.bearer.entity.vo.Video;

import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/10/21 2:12 PM
 */
public interface SearchPageService {
    /**
     * get article search result and save the searchRecords
     * @param searchRecordsDTO
     * @return list of List<ArticleSearch>
     */
    List<Article> getArticleSearchResult(SearchRecordsDTO searchRecordsDTO);

    /**
     * get video search result and save the searchRecords
     * @param searchRecordsDTO
     * @return list of List<VideoSearch>
     */
    List<Video> getVideoSearchResult(SearchRecordsDTO searchRecordsDTO);

    /**
     * get all main material
     * @return all material
     */
    List<Material> getMaterial();

    /**
     * get all dish name by material
     * @return list of dish name
     */
    List<DishName> getDishName(String id);

    /**
     * get user's searchRecords(all now)
     * @param userid
     * @return user's searchRecords
     */
    List<String> getSearchRecords(String userid);
}
