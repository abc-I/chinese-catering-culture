package org.bearer.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/17/21 5:02 PM
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -1192628767811498061L;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

}
