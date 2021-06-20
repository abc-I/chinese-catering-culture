package org.bearer.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.dto.ChangePassword;
import org.bearer.entity.dto.PostId;
import org.bearer.service.AdministratorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 11:28 PM
 */
@RestController
@RequestMapping(value = "/administrator")
public class AdministratorController {

    @Resource
    private AdministratorService administratorService;

    /**
     * delete article by id
     * @param id
     * @return Result contains ifDelete
     */
    @RequiresRoles(value = {"admin"})
    @DeleteMapping(value = "/articleDelete")
    public Result deleteArticle(@RequestBody PostId id) {
        return Result.result200(administratorService.deleteArticle(id));
    }

    /**
     * get all users
     * @return Result contains list of users
     */
    @RequiresRoles(value = {"admin"})
    @GetMapping(value = "/getUsers/{currentPage}/{pageSize}")
    public Result getUsers(@PathVariable int currentPage, @PathVariable int pageSize) {
        return Result.result200(administratorService.getUsers(currentPage, pageSize));
    }


    /**
     * get users by account
     * @param account
     * @return Result contains specified user
     */
    @RequiresRoles(value = {"admin"})
    @GetMapping(value = "/getUsers/{account}")
    public Result getUsersByAccount(@PathVariable String account) {
        return Result.result200(administratorService.getUsersByAccount(account));
    }

    /**
     * lock user's account
     * @param id
     * @return Result contains if locked successfully
     */
    @RequiresRoles(value = {"admin","administrator"})
    @PostMapping(value = "/lock")
    public Result lockUser(@RequestBody PostId id) {
        return Result.result200(administratorService.lockUser(id));
    }

    /**
     * get admins
     * @return Result contains list of admins
     */
    @RequiresRoles(value = {"administrator"})
    @GetMapping(value = "/getAdmins/{currentPage}/{pageSize}")
    public Result getAdmins(@PathVariable int currentPage,@PathVariable int pageSize) {
        return Result.result200(administratorService.getAdmins(currentPage, pageSize));
    }

    /**
     * add admin by account
     * @return Result contains if added
     */
    @RequiresRoles(value = {"administrator"})
    @PostMapping(value = "/addAdmin")
    public Result addAdmin(@RequestBody PostId id) {
        return Result.result200(administratorService.addAdmin(id));
    }

    /**
     * delete admin by account
     * @return Result contains if deleted
     */
    @RequiresRoles(value = {"administrator"})
    @DeleteMapping(value = "/deleteAdmin")
    public Result deleteAdmin(@RequestBody PostId id) {
        return Result.result200(administratorService.deleteAdmin(id));
    }

    /**
     * change password
     * @param changePassword
     * @return Result contains if changed
     */
    @RequiresRoles(value = {"admin","administrator"})
    @PostMapping(value = "/password")
    public Result changePassword(@RequestBody ChangePassword changePassword) {
        return Result.result200(administratorService.changePassword(changePassword));
    }

    /**
     * get not examined articles list
     *
     * @return Result contains list of articles not examined articles
     */
    @RequiresRoles(value = {"admin"})
    @GetMapping(value = "/articleList/{currentPage}/{pageSize}")
    public Result getArticleList(@PathVariable int currentPage, @PathVariable int pageSize) {
        return Result.result200(administratorService.getArticleList(currentPage, pageSize));
    }

    /**
     * examine article by id
     * @param id
     * @return Result contains if successful
     */
    @RequiresRoles(value = {"admin"})
    @PostMapping(value = "/examineArticle")
    public Result examineArticle(@RequestBody PostId id) {
        return Result.result200(administratorService.examineArticle(id));
    }

    /**
     * get videos not examined
     *
     * @return Result contains list of videos not examined
     */
    @RequiresRoles(value = {"admin"})
    @GetMapping(value = "/video/{currentPage}/{pageSize}")
    public Result getVideos(@PathVariable int currentPage, @PathVariable int pageSize) {
        return Result.result200(administratorService.getVideos(currentPage, pageSize));
    }

    /**
     * examine video by id
     *
     * @param id
     * @return Result contains if successful
     */
    @RequiresRoles(value = {"admin"})
    @PostMapping(value = "/examineVideo")
    public Result examineVideo(@RequestBody PostId id) {
        return Result.result200(administratorService.examineVideo(id));
    }

    /**
     * reject article by id
     * @param id
     * @return Result contains if reject successful
     */
    @PostMapping(value = "/rejectArticle")
    public Result rejectArticle(@RequestBody PostId id) {
        return Result.result200(administratorService.rejectArticle(id));
    }

    /**
     * reject video by id
     * @param id
     * @return Result contains iif reject successful
     */
    @PostMapping(value = "/rejectVideo")
    public Result rejectVideo(@RequestBody PostId id) {
        return Result.result200(administratorService.rejectVideo(id));
    }

}
