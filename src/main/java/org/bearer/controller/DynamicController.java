package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.DynamicDTO;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;
import org.bearer.service.DynamicService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 14:45
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    private final DynamicService dynamicService;

    public DynamicController(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    @GetMapping("/getDynamic/{currentPage}/{pageSize}")
    public Result getDynamic(@PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = dynamicService.getDynamic(currentPage, pageSize);
        return Result.result200(page);
    }

    @DeleteMapping("/deleteDynamic")
    public Result deleteDynamicById(@RequestBody Ids ids) {
        int len = dynamicService.deleteDynamicById(ids);
        return Result.result200(len);
    }

    @PostMapping("/insertDynamic")
    public Result insertDynamic(@RequestBody DynamicDTO dynamicDTO) {
        int len = dynamicService.insertDynamic(dynamicDTO);
        return Result.result200(len);
    }
}
