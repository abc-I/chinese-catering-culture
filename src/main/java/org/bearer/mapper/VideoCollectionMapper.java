package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Video;
import org.bearer.entity.po.VideoCollection;
import org.bearer.entity.vo.Article;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:52
 */
@Mapper
public interface VideoCollectionMapper {
    List<Video> selectList(String userId);

    int insertCollection(VideoCollection videoCollection);

    int deleteCollection(Ids ids);
}
