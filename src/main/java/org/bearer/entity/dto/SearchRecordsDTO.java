package org.bearer.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/12/21 10:18 PM
 */
@Data
public class SearchRecordsDTO {
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 搜索内容
     */
    @TableField(value = "search_content")
    private String searchContent;
}
