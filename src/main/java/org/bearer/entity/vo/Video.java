package org.bearer.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 19:39
 */
@Data
public class Video implements Serializable {

    private static final long serialVersionUID = -5543296506528588844L;

    /**
     * 视频id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 视频截图url
     */
    private String picturUrl;

    /**
     * 菜系分类
     */
    private String category;

    /**
     * 主材分类
     */
    private String material;

    /**
     * 点击次数
     */
    private Integer recommend;

    /**
     * 作者名
     */
    private String username;
}
