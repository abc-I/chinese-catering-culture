package org.bearer.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/17/21 4:43 PM
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 8062079611269459136L;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;

}
