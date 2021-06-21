package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.po.BrowsingHistory;
import org.bearer.entity.vo.BrowsingHistoryVO;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/16 14:10
 */
@Mapper
public interface BrowsingHistoryMapper {
    /**
     * 通过用户id查询历史记录
     *
     * @param userId 用户id
     * @param start 第一个index
     * @param end 最后一个index
     * @return HashSet<BrowsingHistory>
     */
    HashSet<BrowsingHistoryVO> selectArticleHistoryByUserId(String userId, int start, int end);

    /**
     * 通过用户id查询历史记录
     *
     * @param userId 用户id
     * @param start 第一个index
     * @param end 最后一个index
     * @return HashSet<BrowsingHistory>
     */
    HashSet<BrowsingHistoryVO> selectVideoHistoryByUserId(String userId, int start, int end);

    /**
     * 通过用户id统计历史记录
     *
     * @param userId 用户id
     * @return int
     */
    int selectCountByUserId(String userId);

    /**
     * 保存历史记录
     *
     * @param browsingHistory JSON{"id":"历史记录id","articleId":"文章id","userId":"用户id"}
     * @return int
     */
    int insertArticleHistory(BrowsingHistory browsingHistory);

    /**
     * 保存视频历史记录
     *
     * @param browsingHistory JSON{"id":"历史记录id","videoId":"视频id","userId":"用户id"}
     * @return int
     */
    int insertVideoHistory(BrowsingHistory browsingHistory);
}
