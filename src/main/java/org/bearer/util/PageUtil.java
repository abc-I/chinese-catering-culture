package org.bearer.util;

import org.bearer.entity.dto.PageDTO;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 20:15
 */
public class PageUtil {

    public static int getStart(PageDTO pageDTO) {
        return (pageDTO.getCurrentPage() - 1) * pageDTO.getPageSize();
    }

    public static int getEnd(PageDTO pageDTO) {
        return pageDTO.getCurrentPage() * pageDTO.getPageSize() - 1;
    }

    public static int getPageCount(int total,int pageSize) {
        int pageCount = total / pageSize;

        return total % pageSize == 0 ? pageCount : pageCount + 1;
    }
}
