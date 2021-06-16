package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.DishName;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/12 18:12
 */
@Mapper
public interface DishNameMapper {
    /**
     * 通过材料id查询菜名
     *
     * @param id 材料id
     * @return List<DishName>
     */
    List<DishName> selectDishNameByMaterialId(String id);
}
