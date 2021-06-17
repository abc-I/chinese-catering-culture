package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Video;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:52
 */
@Mapper
public interface VideoMapper {

    /**
     * 通过点击率排序，获取一定区间内的视频
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Video>
     */
    List<Video> selectList(int start, int end);

    /**
     * 通过视频id获取视频
     *
     * @param id 视频id
     * @return org.bearer.entity.vo.Video
     */
    Video selectOne(String id);

    /**
     * 通过视频标题查询
     *
     * @param searchContent 查询信息
     * @return List<Video>
     */
    List<Video> selectVideoSearchByTitle(String searchContent);

    int selectPraise(String id);

    int updatePraise(Ids ids);
}
