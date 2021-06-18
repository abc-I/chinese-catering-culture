package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.service.PraiseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:40
 */
@RestController
@RequestMapping("/praise")
public class PraiseController {

    @Resource
    private PraiseService praiseService;

    /**
     * 保存文章点赞
     *
     * @param ids 只取id（文章id）
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertArticlePraise")
    public Result insertArticlePraise(Ids ids) {
        int len = praiseService.insertArticlePraise(ids);
        return Result.result200(len);
    }

    /**
     * 保存视频点赞
     *
     * @param ids 只取id（视频id）
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertVideoPraise")
    public Result insertVideoPraise(Ids ids) {
        int len = praiseService.insertVideoPraise(ids);
        return Result.result200(len);
    }
}
