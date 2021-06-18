package org.bearer.service.impl;

import org.bearer.entity.dto.DynamicDTO;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.Dynamic;
import org.bearer.entity.vo.DynamicVO;
import org.bearer.entity.vo.Page;
import org.bearer.mapper.DynamicMapper;
import org.bearer.service.DynamicService;
import org.bearer.util.PageUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:41
 */
@Service
public class DynamicServiceImpl implements DynamicService {

    private final DynamicMapper dynamicMapper;

    public DynamicServiceImpl(DynamicMapper dynamicMapper) {
        this.dynamicMapper = dynamicMapper;
    }

    @Override
    public Page getDynamic(int currentPage, int pageSize) {

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        List<DynamicVO> dynamics = dynamicMapper.selectDynamic(start, end);
        int total = dynamicMapper.selectCount();
        return new Page(total, PageUtil.getPageCount(total, pageSize), dynamics);
    }

    @Override
    public int deleteDynamicById(Ids ids) {
        return dynamicMapper.deleteById(ids);
    }

    @Override
    public int insertDynamic(DynamicDTO dynamicDTO) {
        Dynamic dynamic =
                new Dynamic(UUID.randomUUID().toString(), dynamicDTO.getUserId(),
                        dynamicDTO.getDynamic(), dynamicDTO.getPictureUrl(), dynamicDTO.getVideoUrl());

        return dynamicMapper.insertDynamic(dynamic);
    }

}
