package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.BrowsingHistory;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/16 14:10
 */
@Mapper
public interface BrowsingHistoryMapper {
    List<BrowsingHistory> selectBrowsingHistoryByUserId(String userId);
}
