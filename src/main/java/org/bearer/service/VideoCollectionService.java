package org.bearer.service;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.Video;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:20
 */
public interface VideoCollectionService {
    List<Video> getCollection(String userId);

    int insertCollection(Ids ids);

    int deleteCollection(Ids ids);
}
