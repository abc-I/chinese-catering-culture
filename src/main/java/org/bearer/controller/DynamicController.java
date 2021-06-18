package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.DynamicDTO;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;
import org.bearer.service.DynamicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 14:45
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Resource
    private DynamicService dynamicService;

    /**
     * 获取动态
     *
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return org.bearer.entity.Result
     */
    @GetMapping("/getDynamic/{currentPage}/{pageSize}")
    public Result getDynamic(@PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = dynamicService.getDynamic(currentPage, pageSize);
        return Result.result200(page);
    }

    /**
     * 通过动态id删除动态
     *
     * @param ids JSON{"id":"动态id"}
     * @return org.bearer.entity.Result
     */
    @DeleteMapping("/deleteDynamic")
    public Result deleteDynamicById(@RequestBody Ids ids) {
        int len = dynamicService.deleteDynamicById(ids);
        return Result.result200(len);
    }

    /**
     * 保存动态
     *
     * @param dynamicDTO JSON{"userId":"用户id","dynamic":"动态信息","pictureUrl":"图片url","videoUrl":"视频url"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertDynamic")
    public Result insertDynamic(@RequestBody DynamicDTO dynamicDTO) {
        int len = dynamicService.insertDynamic(dynamicDTO);
        return Result.result200(len);
    }
}
