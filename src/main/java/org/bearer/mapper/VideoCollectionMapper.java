package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.VideoVO;
import org.bearer.entity.po.VideoCollection;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:52
 */
@Mapper
public interface VideoCollectionMapper {
    /**
     * 通过用户id统计收藏的视频数
     *
     * @param userId 用户id
     * @return int
     */
    int selectCountById(String userId);

    /**
     * 通过用户id查询视频
     *
     * @param userId 用户id
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Video>
     */
    List<VideoVO> selectList(String userId, int start, int end);

    /**
     * 保存收藏视频
     *
     * @param videoCollection 收藏信息
     * @return int
     */
    int insertCollection(VideoCollection videoCollection);

    /**
     * 通过视频id和用户id删除收藏
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return int
     */
    int deleteCollection(Ids ids);

    /**
     * 通过userId和文章id，获取收藏id
     *
     * @param ids JSON{"id":"收藏文章id","userId":"用户id"}
     * @return String
     */
    String selectIdByUserId(Ids ids);
}
