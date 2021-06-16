package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
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
        Boolean ifDelete = administratorService.deleteArticle(id.getUserId());
        return Result.result200(ifDelete);
    }

}
