package org.bearer.service.impl;

import org.bearer.entity.dto.ChangePassword;
import org.bearer.entity.dto.PostId;
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
    public Boolean deleteArticle(PostId id) {
        return articleMapper.deleteById(id.getId());
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
    public List<UserVO> getUserByAccount(String account) {
        // 根据用户的account获取User对象
        return userMapper.selectUserByAccount(account);
    }

    /**
     * lock users account
     *
     * @param id
     * @return if locked
     */
    @Override
    public Boolean lockUser(PostId id) {
        // 根据用户的account设置is_locked字段为1
        if (userMapper.selectLockedById(id.getId())) {
            return userMapper.updateNotLockedById(id.getId());
        } else {
           return userMapper.updateIsLockedById(id.getId());
        }
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
    public Boolean addAdmin(PostId id) {
        // 根据用户的account设置管理员
        return userRoleMapper.updateAdminById(id.getId());
    }

    /**
     * delete admin by account
     *
     * @param id
     * @return if deleted
     */
    @Override
    public Boolean deleteAdmin(PostId id) {
        // 根据用户的account删除管理员
        return userRoleMapper.updateUserById(id.getId());
    }

    /**
     * change password
     *
     * @param changePassword
     * @return if changed
     */
    @Override
    public Boolean changePassword(ChangePassword changePassword) {
        User user = userMapper.selectOne(changePassword.getId());

        String oldPassword;
        if (user != null) {
            oldPassword = MD5Util.parse(changePassword.getOldPassword(), user.getSalt());
        }else {
            return false;
        }

        String password = MD5Util.parse(changePassword.getPassword(), user.getSalt());

        // 根据用户的account和password修改密码
        if (oldPassword.equals(user.getPassword())) {
            return userMapper.updatePasswordById(changePassword.getId(), password);
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
        List<ArticleVO> articles = articleMapper.selectListByIsExamined(start, end);
        int total = articleMapper.selectCountNotExamined();

        return new Page(total, PageUtil.getPageCount(total, pageSize), articles);
    }

    /**
     * examine article by id
     *
     * @param id
     * @return if successful
     */
    @Override
    public Boolean examineArticle(PostId id) {
        // 根据文章id通过审核
        return articleMapper.updateIsExaminedById(id.getId());
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
        List<VideoVO> videos = videoMapper.selectListByIsExamined(start,end);
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
    public Boolean examineVideo(PostId id) {
        // 根据视频id通过审核
        return videoMapper.updateIsExaminedById(id.getId());
    }

    /**
     * reject and delete video by id
     *
     * @param id
     * @return if successful
     */
    @Override
    public Boolean deleteVideo(PostId id) {
        return videoMapper.deleteById(id.getId());
    }
}
