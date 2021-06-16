package org.bearer.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/13 19:06
 */
@Data
public class Material implements Serializable {

    private static final long serialVersionUID = -5943978217217277453L;

    /**
     * 主键(UUID)
     */
    private String id;

    /**
     * 主材
     */
    private String material;
}
