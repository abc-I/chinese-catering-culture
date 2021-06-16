package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/8 9:13
 */
@Data
@TableName("cul_user")
public class User implements Serializable {

    private static final long serialVersionUID = 2468573471927967204L;

    /**
     * 主键(openId)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

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
    
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 随机盐
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 是否封号
     */
    @TableField(value = "is_locked")
    private Boolean locked;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;
}
