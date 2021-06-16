package org.bearer.service.impl;

import org.bearer.mapper.ArticleMapper;
import org.bearer.service.AdministratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 11:45 PM
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
    private ArticleMapper articleMapper;

    /**
     * delete the article by id
     *
     * @param id
     * @return ifDelete
     */
    @Override
    public Boolean deleteArticle(String id) {
        return articleMapper.deleteById(id);
    }
}
