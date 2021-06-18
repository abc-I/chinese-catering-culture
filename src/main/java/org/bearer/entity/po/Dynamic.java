package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/7 20:44
 */
@Data
@TableName("cul_dynamic")
public class Dynamic implements Serializable {

    private static final long serialVersionUID = 1605848702825604368L;

    public Dynamic(String id,String userId,String dynamic,String pictureUrl,String videoUrl) {
        this.id = id;
        this.userId = userId;
        this.dynamic = dynamic;
        this.pictureUrl = pictureUrl;
        this.videoUrl = videoUrl;
    }

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 发送文字
     */
    @TableField(value = "dynamic")
    private String dynamic;

    /**
     * 图片url
     */
    @TableField(value = "picture_url")
    private String pictureUrl;

    /**
     * 视频url
     */
    @TableField(value = "video_url")
    private String videoUrl;

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
