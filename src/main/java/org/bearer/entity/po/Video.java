package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bearer.entity.dto.DishVideoDTO;
import org.bearer.entity.dto.VideoDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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
    @TableField(value = "picture_url")
    private String pictureUrl;

    /**
     * 是否审核
     */
    @TableField(value = "is_examined")
    private Boolean examined;

    /**
     * 点击率
     */
    @TableField(value = "recommend")
    private Integer recommend;

    /**
     * 点赞数
     */
    @TableField(value = "praise")
    private Integer praise;

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

    public Video(VideoDTO videoDTO) {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.title = videoDTO.getTitle();
        this.videoUrl = videoDTO.getVideoUrl();
        this.pictureUrl = videoDTO.getPictureUrl();
        this.authorId = videoDTO.getAuthorId();
        this.cuisineId = videoDTO.getCuisineId();
        this.materialId = videoDTO.getMaterialId();
    }

    public Video(DishVideoDTO dishVideoDTO) {
        this.title = dishVideoDTO.getTitle();
        this.videoUrl = dishVideoDTO.getVideoUrl();
        this.pictureUrl = dishVideoDTO.getPictureUrl();
        this.authorId = dishVideoDTO.getAuthorId();
        this.cuisineId = dishVideoDTO.getCuisineId();
        this.materialId = dishVideoDTO.getMaterialId();
    }
}
