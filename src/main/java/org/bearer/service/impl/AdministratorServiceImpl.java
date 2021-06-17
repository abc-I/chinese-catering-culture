package org.bearer.service.impl;

import org.bearer.entity.dto.UserDTO;
import org.bearer.entity.vo.Admin;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.User;
import org.bearer.entity.vo.Video;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.UserMapper;
import org.bearer.mapper.UserRoleMapper;
import org.bearer.mapper.VideoMapper;
import org.bearer.service.AdministratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 11:45 PM
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private VideoMapper videoMapper;

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

    /**
     * get users
     *
     * @return list of User
     */
    @Override
    public List<User> getUsers(int item, int page) {
        // 获取user表中从第一个参数到第二个参数的User类
        return userMapper.selectUserList(item*(page-1),(item*(page-1)+item));
    }

    /**
     * get users by account
     *
     * @param account
     * @return list of User
     */
    @Override
    public List<User> getUsersByAccount(String account) {
        // 根据用户的account获取User对象
        return userMapper.selectUserByAccount(account);
    }

    /**
     * lock users account
     *
     * @param account
     * @return if locked
     */
    @Override
    public Boolean lockUser(String account) {
        // 根据用户的account设置is_locked字段为1
        return userMapper.updateIsLockedByAccount(account);
    }

    /**
     * get admins
     *
     * @return list of admins
     */
    @Override
    public List<Admin> getAdmins() {
        // 根据用户的role列出管理员账号
        return userMapper.selectUserByUserRole();
    }

    /**
     * add admins
     *
     * @return if added
     */
    @Override
    public Boolean addAdmin(String account) {
        // 根据用户的account设置管理员
        return userRoleMapper.updateAdminByAccount(account);
    }

    /**
     * delete admin by account
     *
     * @param account
     * @return if deleted
     */
    @Override
    public Boolean deleteAdmin(String account) {
        // 根据用户的account删除管理员
        return userRoleMapper.updateUserByAccount(account);
    }

    /**
     * change password
     *
     * @param userDTO
     * @return if changed
     */
    @Override
    public Boolean changePassword(UserDTO userDTO) {
        // 根据用户的account和password修改密码
        if (userMapper.selectByAccountAndPassword(userDTO.getAccount(), userDTO.getPassword()) != null) {
            return userMapper.updatePasswordByAccount(userDTO.getAccount(), userDTO.getPassword());
        }
        return false;
    }

    /**
     * get article list
     *
     * @return List of Articles
     */
    @Override
    public List<Article> getArticleList() {
        // 列出未审核的文章列表 需要`id`,`title`,`category`,`material`,`pictureUrl`
        return articleMapper.selectListByIsExamined();
    }

    /**
     * get article content by id
     *
     * @param id
     * @return the article
     */
    @Override
    public String getArticleContent(String id) {
        // 根据文章id获取文章内容
        return articleMapper.selectArticleById(id);
    }

    /**
     * examine article by id
     *
     * @param id
     * @return if successful
     */
    @Override
    public Boolean examineArticle(String id) {
        // 根据文章id通过审核
        return articleMapper.updateIsExaminedById(id);
    }

    /**
     * get videos
     *
     * @return list of videos
     */
    @Override
    public List<Video> getVideos() {
        // 列出未审核的视频列表 需要`id`,`title`,`videoUrl`,`category`,`material`,`pictureUrl`
        return videoMapper.selectListByIsExamined();
    }

    /**
     * examine video by id
     *
     * @param id
     * @return if successful
     */
    @Override
    public Boolean examineVideo(String id) {
        // 根据视频id通过审核
        return videoMapper.updateIsExaminedById(id);
    }


}
