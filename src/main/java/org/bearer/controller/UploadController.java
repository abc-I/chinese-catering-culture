package org.bearer.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.bearer.entity.Result;
import org.bearer.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:02
 */
@RestController
@RequiresRoles(value = {"user", "admin"}, logical = Logical.OR)
@RequestMapping("/upload")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class UploadController {

    @Resource
    private UploadService uploadService;

    /**
     * 上传照片
     *
     * @param file 文件保存对象
     * @return org.bearer.entity.Result
     */
    @PostMapping("/uploadPicture")
    public Result uploadPicture(MultipartFile file) {
        String url = uploadService.uploadPicture(file);
        return result(url);
    }

    /**
     * 上传视频
     *
     * @param file 文件保存对象
     * @return org.bearer.entity.Result
     */
    @PostMapping("/uploadVideo")
    public Result uploadVideo(MultipartFile file) {
        String url = uploadService.uploadVideo(file);
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
