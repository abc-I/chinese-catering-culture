package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/23/21 9:19 AM
 */
@Data
public class DishArticleDTO implements Serializable {

    private static final long serialVersionUID = 7609445704220365442L;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章
     */
    private String article;

    /**
     * 图片url
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
