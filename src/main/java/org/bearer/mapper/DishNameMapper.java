package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.po.DishName;
import org.bearer.entity.vo.DishNameVO;

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
     * @return List<DishNameVO>
     */
    List<DishNameVO> selectDishNameByMaterialId(String id);

    /**
     * 保存菜名
     *
     * @param dishName JSON{"id":"菜名id","name":"菜名","articleId":"文章id","videoId":"视频id"}
     */
    void insertDishName(DishName dishName);
}
