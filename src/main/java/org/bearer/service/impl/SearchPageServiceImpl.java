package org.bearer.service.impl;

import org.bearer.entity.dto.SearchRecordsDTO;
import org.bearer.entity.po.SearchRecords;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.DishName;
import org.bearer.entity.vo.Material;
import org.bearer.entity.vo.Video;
import org.bearer.mapper.*;
import org.bearer.service.SearchPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/10/21 2:15 PM
 */
@Service
public class SearchPageServiceImpl implements SearchPageService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private MaterialMapper materialMapper;
    @Resource
    private DishNameMapper dishNameMapper;
    @Resource
    private VideoMapper videoMapper;
    @Resource
    private SearchRecordsMapper searchRecordsMapper;

    /**
     * get article search result and save the searchRecords
     *
     * @param searchRecordsDTO
     * @return list of List<ArticleSearch>
     */
    @Override
    public List<Article> getArticleSearchResult(SearchRecordsDTO searchRecordsDTO) {
        SearchRecords searchRecords = new SearchRecords();

        searchRecords.setSearchContent(searchRecordsDTO.getSearchContent());
        searchRecords.setUserId(searchRecordsDTO.getUserId());
        searchRecords.setSearchTime(new Date(System.currentTimeMillis()));

        searchRecordsMapper.save(searchRecords);
        System.out.println(articleMapper.selectArticleSearchByTitle(searchRecords.getSearchContent()));
        return articleMapper.selectArticleSearchByTitle(searchRecords.getSearchContent());
    }

    /**
     * get video search result and save the searchRecords
     *
     * @param searchRecordsDTO
     * @return list of List<VideoSearch>
     */
    @Override
    public List<Video> getVideoSearchResult(SearchRecordsDTO searchRecordsDTO) {
        SearchRecords searchRecords = new SearchRecords();

        searchRecords.setSearchContent(searchRecordsDTO.getSearchContent());
        searchRecords.setUserId(searchRecordsDTO.getUserId());
        searchRecords.setSearchTime(new Date(System.currentTimeMillis()));

        searchRecordsMapper.save(searchRecords);
        return videoMapper.selectVideoSearchByTitle(searchRecords.getSearchContent());
    }

    /**
     * get all main material
     *
     * @return all material with `id` `material`
     */
    @Override
    public List<Material> getMaterial() {
        return materialMapper.selectList();
    }

    /**
     * get all dish name by material
     *
     * @param id
     * @return list of dish name with `id` `name`
     */
    @Override
    public List<DishName> getDishName(String id) {
        return dishNameMapper.selectDishNameByMaterialId(id);
    }

    /**
     * get user's searchRecords(all now)
     *
     * @param userId
     * @return user's searchRecords
     */
    @Override
    public List<String> getSearchRecords(String userId) {
        return searchRecordsMapper.selectSearchRecordsByUserId(userId);
    }
}
