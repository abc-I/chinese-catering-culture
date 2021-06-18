package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/16 15:47
 */
@Data
public class UserLogin implements Serializable {

    private static final long serialVersionUID = 5662898438223384908L;

    /**
     * 微信登录的appId
     */
    private String appId;

    /**
     * 微信登录的密钥
     */
    private String secret;

    /**
     * 微信登录的code
     */
    private String code;

    /**
     * 管理员登录的账号
     */
    private String account;

    /**
     * 管理员登录的密码
     */
    private String password;

    /**
     * 旧密码
     */
    private String oldPassword;
}
