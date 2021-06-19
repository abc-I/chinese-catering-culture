package org.bearer.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/19 15:27
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -1323337379894597956L;

    private String role;
}
