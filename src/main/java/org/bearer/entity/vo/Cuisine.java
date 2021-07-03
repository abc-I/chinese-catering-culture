package org.bearer.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/9 19:35
 */
@Data
public class Cuisine implements Serializable {

    private static final long serialVersionUID = 3491337644711091524L;

    /**
     * 菜系分类id
     */
    private String id;

    /**
     * 菜系分类
     */
    private String category;

    /**
     * 图片url
     */
    private String pictureUrl;
}
