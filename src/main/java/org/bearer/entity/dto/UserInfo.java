package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/20 14:37
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1366704101034462036L;

    private String nickName;
    private String avatarUrl;
    private int gender;
}
