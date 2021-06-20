package org.bearer.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.entity.vo.Article;
import org.bearer.entity.vo.BrowsingHistory;
import org.bearer.service.PersonalPageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/15/21 10:39 PM
 */
@RestController
@RequiresRoles(value = {"user"})
@RequestMapping(value = "/personal")
public class PersonalPageController {

    @Resource
    private PersonalPageService personalService;

    /**
     * get the list of self articles
     *
     * @param userId
     * @return Result contain List<Article>
     */
    @GetMapping(value = "/selfArticle/{userId}")
    public Result getSelfArticle(@PathVariable String userId) {
        List<Article> articles = personalService.getSelfArticle(userId);
        return Result.result200(articles);
    }

    @GetMapping(value = "/browsingHistory/{userId}")
    public Result getBrowsingHistory(@PathVariable String userId) {
        List<BrowsingHistory> browsingHistories = personalService.getBrowsingHistory(userId);
        return Result.result200(browsingHistories);
    }
}
