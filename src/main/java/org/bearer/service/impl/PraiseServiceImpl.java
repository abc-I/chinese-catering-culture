package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.VideoMapper;
import org.bearer.service.PraiseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:57
 */
@Service
public class PraiseServiceImpl implements PraiseService {

    /**
     * 文章 mapper
     */
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 视频 mapper
     */
    @Resource
    private VideoMapper videoMapper;

    /**
     * 保存文章点赞
     *
     * @param ids 只取id（文章id）
     * @return int
     */
    @Override
    public int insertArticlePraise(Ids ids) {
        return articleMapper.updatePraise(ids);
    }

    /**
     * 保存视频点赞
     *
     * @param ids 只取id（视频id）
     * @return org.bearer.entity.Result
     */
    @Override
    public int insertVideoPraise(Ids ids) {
        return videoMapper.updatePraise(ids);
    }
}
