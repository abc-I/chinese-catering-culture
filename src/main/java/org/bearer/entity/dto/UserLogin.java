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

    private String appId;

    private String secret;

    private String code;

    private String account;

    private String password;

    private String oldPassword;
}
