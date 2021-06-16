package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/8 9:19
 */
@Data
@TableName("cul_video")
public class Video implements Serializable {

    private static final long serialVersionUID = -1248340255610198733L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 视频url
     */
    @TableField(value = "video_url")
    private String videoUrl;

    /**
     * 视频截图
     */
    @TableField(value = "video_img")
    private String videoImg;

    /**
     * 是否审核
     */
    @TableField(value = "is_examined")
    private Boolean examined;

    /**
     * 作者id
     */
    @TableField(value = "author_id")
    private String authorId;

    /**
     * 菜系分类id
     */
    @TableField(value = "cuisine_id")
    private String cuisineId;

    /**
     * 主材id
     */
    @TableField(value = "material_id")
    private String materialId;

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
