package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Article;
import org.bearer.service.ArticleCollectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/11 13:25
 */
@RestController
@RequestMapping("/article")
public class ArticleCollectionController {

    /**
     * 文章收藏服务层
     */
    private final ArticleCollectionService articleCollectionService;

    public ArticleCollectionController(ArticleCollectionService articleCollectionService) {
        this.articleCollectionService = articleCollectionService;
    }

    /**
     * 获取收藏的文章
     *
     * @param userId 用户id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/getCollection/{userId}")
    public Result getCollection(@PathVariable String userId) {
        List<Article> article = articleCollectionService.getCollection(userId);
        return Result.result200(article);
    }

    /**
     * 保存收藏的文章
     *
     * @param ids JSON{"articleId":"收藏文章id","userId":"用户id"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertCollection")
    public Result insertCollection(@RequestBody Ids ids) {
        int len = articleCollectionService.insertCollection(ids);
        return Result.result200(len);
    }

    /**
     * 删除收藏文章
     *
     * @param ids JSON{"articleId":"收藏文章id","userId":"用户id"}
     * @return org.bearer.entity.Result
     */
    @DeleteMapping("/deleteCollection")
    public Result deleteCollection(@RequestBody Ids ids) {
        int len = articleCollectionService.deleteCollection(ids);
        return Result.result200(len);
    }
}
