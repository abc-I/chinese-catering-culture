package org.bearer.service;


import org.bearer.entity.dto.UserLogin;
import org.bearer.entity.vo.*;

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

    /**
     * get users
     * @return
     */
    Page getUsers(int currentPage, int pageSize);

    /**
     * get users by account
     * @param account
     * @return
     */
    UserVO getUsersByAccount(String account);

    /**
     * lock users account
     * @param account
     * @return if locked
     */
    Boolean lockUser(String account);

    /**
     * get admins
     * @return list of admins
     */
    Page getAdmins(int currentPage, int pageSize);

    /**
     * add admins
     * @return if added
     */
    Boolean addAdmin(String account);

    /**
     * delete admin by account
     * @param account
     * @return if deleted
     */
    Boolean deleteAdmin(String account);

    /**
     * change password
     * @param login
     * @return if changed
     */
    Boolean changePassword(UserLogin login);

    /**
     * get article list
     * @return List of Articles
     */
    Page getArticleList(int currentPage, int pageSize);

    /**
     * get article content by id
     * @param id
     * @return the article
     */
    String getArticleContent(String id);

    /**
     * examine article by id
     * @param id
     * @return if successful
     */
    Boolean examineArticle(String id);

    /**
     * get videos
     * @return list of videos
     */
    Page getVideos(int currentPage, int pageSize);

    /**
     * examine video by id
     * @param id
     * @return if successful
     */
    Boolean examineVideo(String id);
}
