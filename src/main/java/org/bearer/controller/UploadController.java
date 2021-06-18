package org.bearer.controller;

import org.bearer.entity.Result;
import org.bearer.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:02
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/uploadPicture")
    public Result uploadPicture(HttpServletRequest request) {
        String url = uploadService.uploadPicture(request);
        return result(url);
    }

    @PostMapping("/uploadVideo")
    public Result uploadVideo(HttpServletRequest request) {
        String url = uploadService.uploadVideo(request);
        return result(url);
    }

    private Result result(String url) {
        if (url != null) {
            return Result.result200(url);
        } else {
            return Result.result500("Fail：上传失败！");
        }
    }
}
