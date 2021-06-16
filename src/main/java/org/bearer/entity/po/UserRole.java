package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/8 9:17
 */
@Data
@TableName("cul_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 3961324108070552492L;

    /**
     * 主键(UUID)
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private String roleId;

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
