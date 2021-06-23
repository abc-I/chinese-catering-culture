package org.bearer.service.impl;

import org.bearer.entity.po.SearchRecords;
import org.bearer.entity.vo.*;
import org.bearer.mapper.*;
import org.bearer.service.SearchPageService;
import org.bearer.util.PageUtil;
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
     * @param userId
     * @param searchContent
     * @return list of List<ArticleSearch>
     */
    @Override
    public Page getArticleSearchResult(String userId, String searchContent,
                                       int currentPage, int pageSize) {
        SearchRecords searchRecords = new SearchRecords();

        searchRecords.setSearchContent(searchContent);
        searchRecords.setUserId(userId);
        searchRecords.setSearchTime(new Date(System.currentTimeMillis()));

        searchRecordsMapper.save(searchRecords);

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<ArticleVO> articles = articleMapper
                .selectArticleSearchByTitle(searchContent, start, end);

        int total = articleMapper.selectCountByTitle(searchContent);

        return new Page(total, PageUtil.getPageCount(total, pageSize), articles);
    }

    /**
     * get video search result and save the searchRecords
     *
     * @param userId
     * @param searchContent
     * @return list of List<VideoSearch>
     */
    @Override
    public Page getVideoSearchResult(String userId, String searchContent,
                                     int currentPage, int pageSize) {

        SearchRecords searchRecords = new SearchRecords();

        searchRecords.setSearchContent(searchContent);
        searchRecords.setUserId(userId);
        searchRecords.setSearchTime(new Date(System.currentTimeMillis()));

        searchRecordsMapper.save(searchRecords);

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<VideoVO> videos = videoMapper.selectVideoSearchByTitle(searchContent, start, end);

        int total = videoMapper.selectCountByTitle(searchContent);

        return new Page(total, PageUtil.getPageCount(total, pageSize), videos);
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
    public List<DishNameVO> getDishName(String id) {
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
