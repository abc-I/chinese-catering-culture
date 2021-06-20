package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.dto.PostId;
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
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Video>
     */
    List<Video> selectVideoSearchByTitle(String searchContent, int start, int end);

    /**
     * 通过视频id保存点赞数
     *
     * @param id JSON{"id":"视频id"}
     * @return int
     */
    int updatePraise(PostId id);

    /**
     * 查询未审核的视频
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Video>
     */
    List<Video> selectListByIsExamined(int start, int end);

    /**
     * 统计为审核的视频
     *
     * @return int
     */
    int selectCountNotExamined();

    /**
     * 通过视频id审核
     *
     * @param id 视频id
     * @return Boolean
     */
    Boolean updateIsExaminedById(String id);

    /**
     * 统计查询出几条数据
     *
     * @param searchContent 查询内容
     * @return int
     */
    int selectCountByTitle(String searchContent);

    /**
     * 添加视频点击次数
     *
     * @param id 视频id
     */
    void updateRecommend(String id);
}
