package org.bearer.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicVO implements Serializable {

    private static final long serialVersionUID = -3115998728006440008L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 动态内容
     */
    private String dynamic;

    /**
     * 图片url
     */
    private String pictureUrl;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 发动态的时间
     */
    private Date createTime;
}
