package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.VideoCollection;
import org.bearer.entity.vo.Page;
import org.bearer.entity.vo.Video;
import org.bearer.mapper.VideoCollectionMapper;
import org.bearer.service.VideoCollectionService;
import org.bearer.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:20
 */
@Service
public class VideoCollectionServiceImpl implements VideoCollectionService {

    /**
     * 视频收藏 mapper
     */
    @Resource
    private VideoCollectionMapper videoCollectionMapper;

    /**
     * 通过用户id获取收藏的视频
     *
     * @param userId 用户id
     * @param currentPage 当前页数
     * @param pageSize 每页几条
     * @return org.bearer.entity.vo.Page
     */
    @Override
    public Page getCollection(String userId, int currentPage, int pageSize) {
        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<Video> videos = videoCollectionMapper.selectList(userId, start, end);

        int total = videoCollectionMapper.selectCountById(userId);

        return new Page(total, PageUtil.getPageCount(total, pageSize), videos);
    }

    /**
     * 保存收藏视频
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return int
     */
    @Override
    public int insertCollection(Ids ids) {
        String id = UUID.randomUUID().toString().replace("-", "");
        VideoCollection videoCollection =
                new VideoCollection(id, ids.getUserId(), ids.getId());
        return videoCollectionMapper.insertCollection(videoCollection);
    }

    /**
     * 通过用户id和视频id删除收藏
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return int
     */
    @Override
    public int deleteCollection(Ids ids) {
        return videoCollectionMapper.deleteCollection(ids);
    }
}
