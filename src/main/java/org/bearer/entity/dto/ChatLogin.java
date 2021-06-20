package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/16 15:47
 */
@Data
public class ChatLogin implements Serializable {

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
     * 用户名
     */
    private UserProfile userProfile;
}
