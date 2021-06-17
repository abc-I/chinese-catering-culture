package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.service.PraiseService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:40
 */
@RestController
@RequestMapping("/praise")
public class PraiseController {

    private final PraiseService praiseService;

    public PraiseController(PraiseService praiseService) {
        this.praiseService = praiseService;
    }

    @GetMapping("/getArticlePraise/{id}")
    public Result getArticlePraise(@PathVariable String id) {
        int len = praiseService.getArticlePraise(id);
        return Result.result200(len);
    }

    @PostMapping("/insertArticlePraise")
    public Result insertArticlePraise(Ids ids) {
        int len = praiseService.insertArticlePraise(ids);
        return Result.result200(len);
    }

    @GetMapping("/getVideoPraise/{id}")
    public Result getVideoPraise(@PathVariable String id) {
        int len = praiseService.getVideoPraise(id);
        return Result.result200(len);
    }

    @PostMapping("/insertVideoPraise")
    public Result insertVideoPraise(Ids ids) {
        int len = praiseService.insertVideoPraise(ids);
        return Result.result200(len);
    }
}
