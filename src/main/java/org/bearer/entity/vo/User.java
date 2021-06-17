package org.bearer.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/17/21 9:38 AM
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5846953716457613252L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账号
     */
    private String account;

    /**
     * 是否封号
     */
    private Boolean locked;
}
