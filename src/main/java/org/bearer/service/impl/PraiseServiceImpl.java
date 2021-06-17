package org.bearer.service.impl;

import org.bearer.entity.dto.Ids;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.VideoMapper;
import org.bearer.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:57
 */
@Service
public class PraiseServiceImpl implements PraiseService {

    private final ArticleMapper articleMapper;
    private final VideoMapper videoMapper;

    public PraiseServiceImpl(ArticleMapper articleMapper, VideoMapper videoMapper) {
        this.articleMapper = articleMapper;
        this.videoMapper = videoMapper;
    }

    @Override
    public int getArticlePraise(String id) {
        return articleMapper.selectPraise(id);
    }

    @Override
    public int insertArticlePraise(Ids ids) {
        return articleMapper.updatePraise(ids);
    }

    @Override
    public int getVideoPraise(String id) {
        return videoMapper.selectPraise(id);
    }

    @Override
    public int insertVideoPraise(Ids ids) {
        return videoMapper.updatePraise(ids);
    }
}
