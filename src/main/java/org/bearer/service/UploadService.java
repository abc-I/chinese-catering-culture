package org.bearer.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:08
 */
public interface UploadService {
    /**
     * 上传图片
     *
     * @param request 请求对象
     * @return String
     */
    String uploadPicture(HttpServletRequest request);

    /**
     * 上传视频
     *
     * @param request 请求对象
     * @return String
     */
    String uploadVideo(HttpServletRequest request);
}
