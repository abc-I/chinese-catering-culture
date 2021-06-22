package org.bearer.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 19:09
 */
@Data
public class ArticleVO implements Serializable {

    private static final long serialVersionUID = -8686544735374852463L;

    /**
     * 文章id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章
     */
    private String article;

    /**
     * 菜系分类
     */
    private String category;

    /**
     * 主材分类
     */
    private String material;

    /**
     * 图片url
     */
    private String pictureUrl;

    /**
     * 点击次数
     */
    private Integer recommend;

    /**
     * 点赞数
     */
    private Integer praise;

    /**
     * 作者名
     */
    private String username;

    /**
     * 文章创建时间
     */
    private Date createTime;
}