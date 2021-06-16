package org.bearer.service;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 11:43 PM
 */
public interface AdministratorService {

    /**
     * delete the article by id
     * @param id
     * @return ifDelete
     */
    Boolean deleteArticle(String id);
}
