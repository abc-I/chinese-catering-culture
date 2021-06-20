package org.bearer.service.impl;

import org.bearer.entity.dto.DynamicDTO;
import org.bearer.entity.dto.PostId;
import org.bearer.entity.po.Dynamic;
import org.bearer.entity.vo.DynamicVO;
import org.bearer.entity.vo.Page;
import org.bearer.mapper.DynamicMapper;
import org.bearer.service.DynamicService;
import org.bearer.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:41
 */
@Service
public class DynamicServiceImpl implements DynamicService {

    /**
     * 动态mapper
     */
    @Resource
    private DynamicMapper dynamicMapper;

    /**
     * 获取动态
     *
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return org.bearer.entity.vo.Page
     */
    @Override
    public Page getDynamic(int currentPage, int pageSize) {

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<DynamicVO> dynamics = dynamicMapper.selectDynamic(start, end);
        int total = dynamicMapper.selectCount();
        return new Page(total, PageUtil.getPageCount(total, pageSize), dynamics);
    }

    /**
     * 同动态id删除动态
     *
     * @param id JSON{"id":"动态id"}
     * @return int
     */
    @Override
    public int deleteDynamicById(PostId id) {
        return dynamicMapper.deleteById(id);
    }

    /**
     * 保存动态信息
     *
     * @param dynamicDTO JSON{"userId":"用户id","dynamic":"动态信息","pictureUrl":"图片url","videoUrl":"视频url"}
     * @return int
     */
    @Override
    public int insertDynamic(DynamicDTO dynamicDTO) {
        String id = UUID.randomUUID().toString().replace("-", "");

        Dynamic dynamic =
                new Dynamic(id, dynamicDTO.getUserId(),
                        dynamicDTO.getDynamic(), dynamicDTO.getPictureUrl(), dynamicDTO.getVideoUrl());

        return dynamicMapper.insertDynamic(dynamic);
    }

}
