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
    User selectOne(String account);

    List<UserVO> selectUserList(int start, int end);

    int selectCountUser();

    UserVO selectUserByAccount(String account);

    Boolean updateIsLockedByAccount(String account);

    List<UserVO> selectUserByUserRole(int start, int end);

    int selectCountAdmin();

    User selectByAccountAndPassword(String account);

    Boolean updatePasswordByAccount(String account, String password);
}
