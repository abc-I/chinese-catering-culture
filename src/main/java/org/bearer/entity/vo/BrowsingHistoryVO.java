package org.bearer.entity.vo;

import lombok.Data;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 11:04 PM
 */
@Data
public class BrowsingHistoryVO {

    /**
     * 文章或视频的Id
     */
    private String id;

    /**
     * 图片url
     */
    private String pictureUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String username;

    /**
     * 主材
     */
    private String material;

    /**
     * 菜系
     */
    private String category;
}
