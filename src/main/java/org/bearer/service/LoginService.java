package org.bearer.service;

import org.bearer.entity.dto.UserLogin;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:43
 */
public interface LoginService {
    String weChatLogin(UserLogin login);
}
