package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.vo.Page;
import org.bearer.entity.vo.Video;
import org.bearer.service.VideoCollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 12:16
 */
@RestController
@RequestMapping("/video")
public class VideoCollectionController {

    @Resource
    private VideoCollectionService videoCollectionService;

    /**
     * 获取收藏的文章
     *
     * @param userId 用户id
     * @return org.bearer.entity.Result
     */
    @GetMapping("/getCollection/{userId}/{currentPage}/{pageSize}")
    public Result getCollection(@PathVariable String userId,
                                @PathVariable int currentPage, @PathVariable int pageSize) {

        Page page = videoCollectionService.getCollection(userId, currentPage, pageSize);
        return Result.result200(page);
    }

    /**
     * 保存收藏的文章
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return org.bearer.entity.Result
     */
    @PostMapping("/insertCollection")
    public Result insertCollection(@RequestBody Ids ids) {
        int len = videoCollectionService.insertCollection(ids);
        return Result.result200(len);
    }

    /**
     * 删除收藏文章
     *
     * @param ids JSON{"id":"收藏视频id","userId":"用户id"}
     * @return org.bearer.entity.Result
     */
    @DeleteMapping("/deleteCollection")
    public Result deleteCollection(@RequestBody Ids ids) {
        int len = videoCollectionService.deleteCollection(ids);
        return Result.result200(len);
    }
}