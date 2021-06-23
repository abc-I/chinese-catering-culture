package org.bearer.service;


import org.bearer.entity.dto.ChangePassword;
import org.bearer.entity.dto.PostId;
import org.bearer.entity.vo.*;

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
    Boolean deleteArticle(PostId id);

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
    List<UserVO> getUserByAccount(String account);

    /**
     * lock users account
     * @param id
     * @return if locked
     */
    Boolean lockUser(PostId id);

    /**
     * get admins
     * @return list of admins
     */
    Page getAdmins(int currentPage, int pageSize);

    /**
     * add admins
     * @return if added
     */
    Boolean addAdmin(PostId id);

    /**
     * delete admin by account
     * @param id
     * @return if deleted
     */
    Boolean deleteAdmin(PostId id);

    /**
     * change password
     * @param changePassword
     * @return if changed
     */
    Boolean changePassword(ChangePassword changePassword);

    /**
     * get article list
     * @return List of Articles
     */
    Page getArticleList(int currentPage, int pageSize);

    /**
     * examine article by id
     * @param id
     * @return if successful
     */
    Boolean examineArticle(PostId id);

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
    Boolean examineVideo(PostId id);

    Boolean deleteVideo(PostId id);
}
