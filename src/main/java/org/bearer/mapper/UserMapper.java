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
     * @param id 账号
     * @return org.bearer.entity.po.User
     */
    User selectOne(String id);

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
     * @param account 用户id
     * @return org.bearer.entity.vo.UserVO
     */
    List<UserVO> selectUserByAccount(String account);

    /**
     * 通过用户账号封号
     *
     * @param id 用户id
     * @return Boolean
     */
    Boolean updateIsLockedById(String id);

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
     * @param id 账号
     * @param password 密码
     * @return Boolean
     */
    Boolean updatePasswordById(String id, String password);

    /**
     * 保存微信端用户信息
     *
     * @param user JSON{"id":"用户id","username":"用户名","account":"账号","locked":"是否封号"}
     * @return int
     */
    int insertWeChat(User user);

    /**
     * 通过账号锁定用户
     *
     * @param id 用户id
     * @return Boolean
     */
    Boolean selectLockedById(String id);

    /**
     * 通过账号解锁账号
     *
     * @param id 账号
     * @return Boolean
     */
    Boolean updateNotLockedById(String id);

    /**
     * 通过账号查找id
     *
     * @param account 账号
     * @return String
     */
    String selectIdByAccount(String account);

    /**
     * 通过id获取user
     *
     * @param id 主键
     * @return org.bearer.entity.po.User
     */
    User selectById(String id);

    /**
     * 保存用户信息
     *
     * @param user JSON{"id":"用户id","username":"用户名","account":"账号",
     *             "password":"密码","salt":"随机盐","locked":"是否封号"}
     * @return boolean
     */
    boolean insertOne(User user);
}
