package org.bearer.service;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:20
 */
public interface VideoCollectionService {
    /**
     * 通过用户id获取收藏视频
     *
     * @param userId 用户id
     * @param currentPage 当前页数
     * @param pageSize 每页几条
     * @return org.bearer.entity.vo.Page
     */
    Page getCollection(String userId, int currentPage, int pageSize);

    /**
     * 操作收藏信息
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return int
     */
    int collection(Ids ids);
}
