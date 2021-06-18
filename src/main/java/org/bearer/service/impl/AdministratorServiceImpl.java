package org.bearer.service.impl;

import org.bearer.entity.dto.UserLogin;
import org.bearer.entity.po.User;
import org.bearer.entity.vo.*;
import org.bearer.mapper.ArticleMapper;
import org.bearer.mapper.UserMapper;
import org.bearer.mapper.UserRoleMapper;
import org.bearer.mapper.VideoMapper;
import org.bearer.service.AdministratorService;
import org.bearer.util.MD5Util;
import org.bearer.util.PageUtil;
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
     * @return list of UserVO
     */
    @Override
    public Page getUsers(int currentPage, int pageSize) {

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        // 获取user表中从第一个参数到第二个参数的User类
        List<UserVO> users = userMapper.selectUserList(start, end);
        int total = userMapper.selectCountUser();

        return new Page(total, PageUtil.getPageCount(total, pageSize), users);
    }

    /**
     * get users by account
     *
     * @param account
     * @return list of UserVO
     */
    @Override
    public UserVO getUsersByAccount(String account) {
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
    public Page getAdmins(int currentPage, int pageSize) {

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        // 根据用户的role列出管理员账号
        List<UserVO> admins = userMapper.selectAdminByUserRole(start, end);
        int total = userMapper.selectCountAdmin();

        return new Page(total, PageUtil.getPageCount(total, pageSize), admins);
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
     * @param login
     * @return if changed
     */
    @Override
    public Boolean changePassword(UserLogin login) {
        User user = userMapper.selectOne(login.getAccount());

        String oldPassword;
        if (user != null) {
            oldPassword = MD5Util.parse(login.getOldPassword(), user.getSalt());
        }else {
            return false;
        }

        String password = MD5Util.parse(login.getPassword(), user.getSalt());

        // 根据用户的account和password修改密码
        if (oldPassword.equals(user.getPassword())) {
            return userMapper.updatePasswordByAccount(login.getAccount(), password);
        }
        return false;
    }

    /**
     * get article list
     *
     * @return List of Articles
     */
    @Override
    public Page getArticleList(int currentPage, int pageSize) {

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        // 列出未审核的文章列表 需要`id`,`title`,`category`,`material`,`pictureUrl`
        List<Article> articles = articleMapper.selectListByIsExamined(start, end);
        int total = articleMapper.selectCountNotExamined();

        return new Page(total, PageUtil.getPageCount(total, pageSize), articles);
    }

    /**
     * get article content by id
     *
     * @param id
     * @return the article
     */
    @Override
    public Article getArticleContent(String id) {
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
    public Page getVideos(int currentPage, int pageSize) {

        int start = PageUtil.getStart(currentPage, pageSize);
        int end = PageUtil.getEnd(currentPage, pageSize);

        // 列出未审核的视频列表 需要`id`,`title`,`videoUrl`,`category`,`material`,`pictureUrl`
        List<Video> videos = videoMapper.selectListByIsExamined(start,end);
        int total = videoMapper.selectCountNotExamined();

        return new Page(total, PageUtil.getPageCount(total, pageSize), videos);
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
