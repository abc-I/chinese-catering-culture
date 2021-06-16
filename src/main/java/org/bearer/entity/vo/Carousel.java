package org.bearer.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 18:51
 */
@Data
public class Carousel implements Serializable {

    private static final long serialVersionUID = -799448312793762069L;

    /**
     * 文章id
     */
    private String id;

    /**
     * 轮播图url
     */
    private String pictureUrl;
}
