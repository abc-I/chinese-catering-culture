package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.po.User;
import org.bearer.entity.vo.UserVO;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:49
 */
@Mapper
public interface UserMapper {
    /**
     * 通过账号查询用户信息
     *
     * @param account 账号
     * @return org.bearer.entity.po.User
     */
    User selectOne(String account);

    /**
     * 查询用户
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<UserVO>
     */
    List<UserVO> selectUserList(int start, int end);

    /**
     * 统计user用户总数
     *
     * @return int
     */
    int selectCountUser();

    /**
     * 通过账号查询user用户信息
     *
     * @param account 用户账号
     * @return org.bearer.entity.vo.UserVO
     */
    UserVO selectUserByAccount(String account);

    /**
     * 通过用户账号封号
     *
     * @param account 用户账号
     * @return Boolean
     */
    Boolean updateIsLockedByAccount(String account);

    /**
     * 查询所有admin账号
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<UserVO>
     */
    List<UserVO> selectAdminByUserRole(int start, int end);

    /**
     * 统计admin用户总数
     *
     * @return int
     */
    int selectCountAdmin();

    /**
     * 根据账号更新密码
     *
     * @param account 账号
     * @param password 密码
     * @return Boolean
     */
    Boolean updatePasswordByAccount(String account, String password);
}
