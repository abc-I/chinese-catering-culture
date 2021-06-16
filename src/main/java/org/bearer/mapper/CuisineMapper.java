package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.Cuisine;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:45
 */
@Mapper
public interface CuisineMapper {

    /**
     * 获取所有分类信息
     *
     * @return List<Cuisine>
     */
    List<Cuisine> selectAll();
}
