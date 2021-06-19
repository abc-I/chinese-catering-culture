package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;
import org.bearer.service.ArticleCollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private ArticleCollectionService articleCollectionService;

    /**
     * 获取收藏的文章
     *
     * @param userId 用户id
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return org.bearer.entity.Result
     */
    @GetMapping("/getCollection/{userId}/{currentPage}/{pageSize}")
    public Result getCollection(@PathVariable String userId,
                                @PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = articleCollectionService.getCollection(userId, currentPage, pageSize);
        return Result.result200(page);
    }

    /**
     * 操作收藏的文章
     *
     * @param ids JSON{"id":"收藏文章id","userId":"用户id"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/collection")
    public Result articleCollection(@RequestBody Ids ids) {
        int len = articleCollectionService.collection(ids);
        return Result.result200(len);
    }
}
