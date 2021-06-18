package org.bearer.service;

import org.bearer.entity.dto.DynamicDTO;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:41
 */
public interface DynamicService {
    Page getDynamic(int currentPage, int pageSize);

    int deleteDynamicById(Ids ids);

    int insertDynamic(DynamicDTO dynamicDTO);
}
