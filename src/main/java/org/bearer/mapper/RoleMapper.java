package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:48
 */
@Mapper
public interface RoleMapper {
    /**
     * 通过用户id查询权限
     *
     * @param id 用户id
     * @return Set<String>
     */
    Set<String> selectRolesByUserId(String id);
}
