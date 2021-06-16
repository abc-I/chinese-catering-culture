package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.po.SearchRecords;

import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/12/21 9:44 PM
 */
@Mapper
public interface SearchRecordsMapper {
    /**
     * 保存搜索记录
     *
     * @param searchRecords 搜索记录信息
     */
    void save(SearchRecords searchRecords);

    /**
     * 通过用户id查询搜索记录
     *
     * @param userId 用户id
     * @return List<String>
     */
    List<String> selectSearchRecordsByUserId(String userId);
}
