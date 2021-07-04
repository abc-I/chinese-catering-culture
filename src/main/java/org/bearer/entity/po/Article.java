package org.bearer.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bearer.entity.dto.ArticleDTO;
import org.bearer.entity.dto.DishArticleDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/7 20:14
 */
@Data
@TableName("cul_article")
public class Article implements Serializable {

    private static final long serialVersionUID = -2807274663575690171L;

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
     * 文章
     */
    @TableField(value = "article")
    private String article;

    /**
     * 图片url
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

    public Article(ArticleDTO articleDTO) {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.title = articleDTO.getTitle();
        this.article = articleDTO.getArticle();
        this.pictureUrl = articleDTO.getPictureUrl();
        this.authorId = articleDTO.getAuthorId();
        this.cuisineId = articleDTO.getCuisineId();
        this.materialId = articleDTO.getMaterialId();
    }

    public Article(DishArticleDTO dishArticleDTO) {
        this.title = dishArticleDTO.getTitle();
        this.article = dishArticleDTO.getArticle();
        this.pictureUrl = dishArticleDTO.getPictureUrl();
        this.authorId = dishArticleDTO.getAuthorId();
        this.cuisineId = dishArticleDTO.getCuisineId();
        this.materialId = dishArticleDTO.getMaterialId();
    }
}