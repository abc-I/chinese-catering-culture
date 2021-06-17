package org.bearer.entity.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 19:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO implements Serializable {

    private static final long serialVersionUID = -7932985249345692748L;

    /**
     * 每页几条
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;
}
