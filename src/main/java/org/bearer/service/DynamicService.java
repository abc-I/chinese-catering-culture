package org.bearer.service;

import org.bearer.entity.dto.DynamicDTO;
import org.bearer.entity.dto.PostId;
import org.bearer.entity.vo.Page;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:41
 */
public interface DynamicService {
    /**
     * 获取动态
     *
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return org.bearer.entity.vo.Page
     */
    Page getDynamic(int currentPage, int pageSize);

    /**
     * 同动态id删除动态
     *
     * @param id JSON{"id":"动态id"}
     * @return int
     */
    int deleteDynamicById(PostId id);

    /**
     * 保存动态信息
     *
     * @param dynamicDTO JSON{"userId":"用户id","dynamic":"动态信息","pictureUrl":"图片url","videoUrl":"视频url"}
     * @return int
     */
    int insertDynamic(DynamicDTO dynamicDTO);
}
