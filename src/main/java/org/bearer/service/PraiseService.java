package org.bearer.service;

import org.bearer.entity.dto.Ids;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:56
 */
public interface PraiseService {

    /**
     * 保存文章点赞
     *
     * @param ids 只取id（文章id）
     * @return int
     */
    int insertArticlePraise(Ids ids);

    /**
     * 保存视频点赞
     *
     * @param ids 只取id（视频id）
     * @return int
     */
    int insertVideoPraise(Ids ids);
}
