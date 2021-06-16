package org.bearer.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/12 18:11
 */
@Data
public class DishName implements Serializable {

    private static final long serialVersionUID = 5775398720627010770L;

    /**
     * 主键(UUID)
     */
    private String id;

    /**
     * 菜名
     */
    private String name;
}
