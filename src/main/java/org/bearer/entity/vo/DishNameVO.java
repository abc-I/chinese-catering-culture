package org.bearer.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/13 19:11
 */
@Data
public class DishNameVO implements Serializable {

    private static final long serialVersionUID = -4137510215121853770L;

    /**
     * 菜名id
     */
    private String id;

    /**
     * 菜名
     */
    private String name;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 视频id
     */
    private String videoId;
}
