package org.bearer.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:02
 */
@RestController
@RequiresRoles(value = {"user", "admin"})
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    /**
     * 上传照片
     *
     * @param request 请求对象
     * @return org.bearer.entity.Result
     */
    @PostMapping("/uploadPicture")
    public Result uploadPicture(HttpServletRequest request) {
        String url = uploadService.uploadPicture(request);
        return result(url);
    }

    /**
     * 上传视频
     *
     * @param request 请求对象
     * @return org.bearer.entity.Result
     */
    @PostMapping("/uploadVideo")
    public Result uploadVideo(HttpServletRequest request) {
        String url = uploadService.uploadVideo(request);
        return result(url);
    }

    /**
     * 判读url
     *
     * @param url url
     * @return org.bearer.entity.Result
     */
    private Result result(String url) {
        if (url != null) {
            return Result.result200(url);
        } else {
            return Result.result500("Fail：上传失败！");
        }
    }
}
