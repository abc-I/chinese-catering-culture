package org.bearer.service.impl;

import org.bearer.entity.dto.PostId;
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
     * @param id JSON{"id":"文章"}
     * @return int
     */
    @Override
    public int insertArticlePraise(PostId id) {
        return articleMapper.updatePraise(id);
    }

    /**
     * 保存视频点赞
     *
     * @param id JSON{"id":"视频id"}
     * @return org.bearer.entity.Result
     */
    @Override
    public int insertVideoPraise(PostId id) {
        return videoMapper.updatePraise(id);
    }
}
