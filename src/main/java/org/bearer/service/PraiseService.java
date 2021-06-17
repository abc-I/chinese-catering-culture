package org.bearer.service;

import org.bearer.entity.dto.Ids;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:56
 */
public interface PraiseService {
    int getArticlePraise(String id);

    int insertArticlePraise(Ids ids);

    int getVideoPraise(String id);

    int insertVideoPraise(Ids ids);
}
