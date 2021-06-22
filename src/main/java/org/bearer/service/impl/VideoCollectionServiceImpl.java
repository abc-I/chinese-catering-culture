package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.VideoCollection;
import org.bearer.entity.vo.Page;
import org.bearer.entity.vo.VideoVO;
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

        List<VideoVO> videos = videoCollectionMapper.selectList(userId, start, end);

        int total = videoCollectionMapper.selectCountById(userId);

        return new Page(total, PageUtil.getPageCount(total, pageSize), videos);
    }

    /**
     * 操作收藏视频
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return int
     */
    @Override
    public int collection(Ids ids) {
        String id = UUID.randomUUID().toString().replace("-", "");
        VideoCollection videoCollection =
                new VideoCollection(id, ids.getUserId(), ids.getId());

        String collectionId = videoCollectionMapper.selectIdByUserId(ids);

        if (collectionId != null) {
            return videoCollectionMapper.deleteCollection(ids);
        } else {
            return videoCollectionMapper.insertCollection(videoCollection);
        }
    }
}
