package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/23/21 9:40 AM
 */
@Data
public class DishVideoDTO implements Serializable {

    private static final long serialVersionUID = 713816311550966584L;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 视频截图
     */
    private String pictureUrl;

    /**
     * 作者id
     */
    private String authorId;

    /**
     * 菜系分类id
     */
    private String cuisineId;

    /**
     * 主材id
     */
    private String materialId;

    /**
     * 菜名
     */
    private String name;

}
