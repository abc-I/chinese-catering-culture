package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 14:57
 */
@Data
public class DynamicDTO implements Serializable {
    private static final long serialVersionUID = -8618483179951478196L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 发送文字
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
}
