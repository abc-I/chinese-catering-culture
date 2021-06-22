package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:50
 */
@Mapper
public interface UserRoleMapper {
    /**
     * 修改账号权限为admin
     *
     * @param id 账号
     * @return Boolean
     */
    Boolean updateAdminById(String id);

    /**
     * 修改账号权限为user
     *
     * @param id 账号
     * @return Boolean
     */
    Boolean updateUserById(String id);

    /**
     * 用户绑定权限
     *
     * @param id 用户id
     * @return int
     */
    int insertRole(String id);
}
