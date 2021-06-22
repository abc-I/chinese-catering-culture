package org.bearer.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/22/21 9:27 AM
 */
@Data
public class VideoDTO implements Serializable {

    private static final long serialVersionUID = 4220432718859788043L;

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
}
