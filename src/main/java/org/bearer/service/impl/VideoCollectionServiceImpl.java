package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.VideoCollection;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.Video;
import org.bearer.mapper.VideoCollectionMapper;
import org.bearer.service.VideoCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:20
 */
@Service
public class VideoCollectionServiceImpl implements VideoCollectionService {

    private final VideoCollectionMapper videoCollectionMapper;

    public VideoCollectionServiceImpl(VideoCollectionMapper videoCollectionMapper) {
        this.videoCollectionMapper = videoCollectionMapper;
    }

    @Override
    public List<Video> getCollection(String userId) {
        return videoCollectionMapper.selectList(userId);
    }

    @Override
    public int insertCollection(Ids ids) {
        String id = UUID.randomUUID().toString().replace("-", "");
        VideoCollection videoCollection =
                new VideoCollection(id, ids.getUserId(), ids.getId());
        return videoCollectionMapper.insertCollection(videoCollection);
    }

    @Override
    public int deleteCollection(Ids ids) {
        return videoCollectionMapper.deleteCollection(ids);
    }
}
