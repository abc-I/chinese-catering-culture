package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.po.User;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:49
 */
@Mapper
public interface UserMapper {
    User selectOne(String account);
}
