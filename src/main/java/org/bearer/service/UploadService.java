package org.bearer.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:08
 */
public interface UploadService {
    String uploadPicture(HttpServletRequest request);

    String uploadVideo(HttpServletRequest request);
}
