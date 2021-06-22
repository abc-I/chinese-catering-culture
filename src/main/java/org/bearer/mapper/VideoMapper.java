package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.PostId;
import org.bearer.entity.po.Video;
import org.bearer.entity.vo.VideoVO;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:52
 */
@Mapper
public interface VideoMapper {

    /**
     * 通过视频id获取视频
     *
     * @param id 视频id
     * @return org.bearer.entity.vo.Video
     */
    VideoVO selectOne(String id);

    /**
     * 通过视频标题查询
     *
     * @param searchContent 查询信息
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Video>
     */
    List<VideoVO> selectVideoSearchByTitle(String searchContent, int start, int end);

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
    List<VideoVO> selectListByIsExamined(int start, int end);

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

    /**
     * 通过id删除视频
     *
     * @param id 视频id
     * @return Boolean
     */
    Boolean deleteById(String id);

    /**
     * 通过菜系分类获取视频
     *
     * @param id 菜系分类
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<Video>
     */
    List<VideoVO> selectByCuisine(String id, int start, int end);

    /**
     * 通过菜系id统计
     *
     * @param id 菜系id
     * @return int
     */
    int selectCountByCuisine(String id);

    /**
     * 上传视频信息
     *
     * @param video JSON{"id":"视频id","title":"视频标题","videoUrl":"视频url",
     *              "pictureUrl":"图片url","authorId":"作者id","cuisineId":"菜系分类id",
     *              "materialId":"主材分类id"}
     * @return Boolean
     */
    Boolean insertVideo(Video video);
}
