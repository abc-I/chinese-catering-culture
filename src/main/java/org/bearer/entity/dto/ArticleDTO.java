package org.bearer.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/22/21 9:02 AM
 */
@Data
public class ArticleDTO implements Serializable {

    private static final long serialVersionUID = 8778550137609506617L;

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

}
