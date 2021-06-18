package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.dto.UserLogin;
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
    @DeleteMapping(value = "/articleDelete")
    public Result deleteArticle(@RequestBody Ids id) {
        return Result.result200(administratorService.deleteArticle(id.getId()));
    }

    /**
     * get all users
     * @return Result contains list of users
     */
    @GetMapping(value = "/getUsers/{currentPage}/{pageSize}")
    public Result getUsers(@PathVariable int currentPage, @PathVariable int pageSize) {
        return Result.result200(administratorService.getUsers(currentPage, pageSize));
    }


    /**
     * get users by account
     * @param account
     * @return Result contains specified user
     */
    @GetMapping(value = "/getUsers/{account}")
    public Result getUsersByAccount(@PathVariable String account) {
        return Result.result200(administratorService.getUsersByAccount(account));
    }

    /**
     * lock user's account
     * @param account
     * @return Result contains if locked successfully
     */
    @PostMapping(value = "/lock")
    public Result lockUser(@RequestParam String account) {
        return Result.result200(administratorService.lockUser(account));
    }

    /**
     * get admins
     * @return Result contains list of admins
     */
    @GetMapping(value = "/getAdmin/{currentPage}/{pageSize}")
    public Result getAdmins(@PathVariable int currentPage,@PathVariable int pageSize) {
        return Result.result200(administratorService.getAdmins(currentPage, pageSize));
    }

    /**
     * add admin by account
     * @return Result contains if added
     */
    @PostMapping(value = "/addAdmin")
    public Result addAdmin(@RequestParam String account) {
        return Result.result200(administratorService.addAdmin(account));
    }

    /**
     * delete admin by account
     * @return Result contains if deleted
     */
    @DeleteMapping(value = "/deleteAdmin")
    public Result deleteAdmin(@RequestParam String account) {
        return Result.result200(administratorService.deleteAdmin(account));
    }

    /**
     * change password
     * @param login
     * @return Result contains if changed
     */
    @PostMapping(value = "/password")
    public Result changePassword(@RequestBody UserLogin login) {
        return Result.result200(administratorService.changePassword(login));
    }

    /**
     * get not examined articles list
     *
     * @return Result contains list of articles not examined articles
     */
    @GetMapping(value = "/articleList/{currentPage}/{pageSize}")
    public Result getArticleList(@PathVariable int currentPage, @PathVariable int pageSize) {
        return Result.result200(administratorService.getArticleList(currentPage, pageSize));
    }

    /**
     * get article content by id
     * @param id
     * @return Result contains article content
     */
    @GetMapping(value = "/content/{id}")
    public Result getArticleContent(@PathVariable String id) {
        return Result.result200(administratorService.getArticleContent(id));
    }

    /**
     * examine article by id
     * @param id
     * @return Result contains if successful
     */
    @PostMapping(value = "/examineArticle/{id}")
    public Result examineArticle(@PathVariable String id) {
        return Result.result200(administratorService.examineArticle(id));
    }

    /**
     * get videos not examined
     *
     * @return Result contains list of videos not examined
     */
    @GetMapping(value = "/video/{currentPage}/{pageSize}")
    public Result getVideos(@PathVariable int currentPage, @PathVariable int pageSize) {
        return Result.result200(administratorService.getVideos(currentPage, pageSize));
    }

    /**
     * examine video by id
     * @param id
     * @return Result contains if successful
     */
    @PostMapping(value = "/examineVideo/{id}")
    public Result examineVideo(@PathVariable String id) {
        return Result.result200(administratorService.examineVideo(id));
    }
}
