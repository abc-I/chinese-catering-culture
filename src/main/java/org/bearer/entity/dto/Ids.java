package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/11 14:08
 */
@Data
public class Ids implements Serializable {

    private static final long serialVersionUID = -4394553501686660633L;

    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;
}
