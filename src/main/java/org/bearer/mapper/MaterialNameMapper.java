package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 15:40
 */
@Mapper
public interface MaterialNameMapper {
    /**
     * 主材和菜名的关联
     *
     * @param materialId 主材id
     * @param id 菜名id
     * @return boolean
     */
    Boolean insertMaterialName(String materialId, String id);
}
