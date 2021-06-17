package org.bearer.service;


import org.bearer.entity.dto.UserDTO;
import org.bearer.entity.vo.Admin;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.User;
import org.bearer.entity.vo.Video;

import java.util.List;

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
    List<User> getUsers(int item, int page);

    /**
     * get users by account
     * @param account
     * @return
     */
    List<User> getUsersByAccount(String account);

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
    List<Admin> getAdmins();

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
     * @param userDTO
     * @return if changed
     */
    Boolean changePassword(UserDTO userDTO);

    /**
     * get article list
     * @return List of Articles
     */
    List<Article> getArticleList();

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
    List<Video> getVideos();

    /**
     * examine video by id
     * @param id
     * @return if successful
     */
    Boolean examineVideo(String id);
}
