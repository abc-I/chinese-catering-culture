package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.Material;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:47
 */
@Mapper
public interface MaterialMapper {
    /**
     * 查询所有材料名
     *
     * @return List<Material>
     */
    List<Material> selectList();
}
