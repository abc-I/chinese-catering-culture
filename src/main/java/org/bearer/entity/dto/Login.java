package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/19 19:53
 */
@Data
public class Login implements Serializable {

    private static final long serialVersionUID = -8548627437768911822L;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}
