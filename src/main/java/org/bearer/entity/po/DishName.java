package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bearer.entity.dto.DishArticleDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/12 18:11
 */
@Data
@TableName("cul_dish_name")
public class DishName implements Serializable {

    private static final long serialVersionUID = 5775398720627010770L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 菜名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 文章id
     */
    @TableField(value = "article_id")
    private String articleId;

    /**
     * 视频id
     */
    @TableField(value = "video_id")
    private String videoId;

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

    public DishName(String dishName, String articleId, String videoId) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = dishName;
        this.articleId = articleId;
        this.videoId = videoId;
    }
}
