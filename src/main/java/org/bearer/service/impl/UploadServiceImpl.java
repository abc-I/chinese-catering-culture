package org.bearer.service.impl;

import org.bearer.service.UploadService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:09
 */
@Service
public class UploadServiceImpl implements UploadService {

    /**
     * 上传图片
     *
     * @param request 请求对象
     * @return String
     */
    @Override
    public String uploadPicture(HttpServletRequest request) {
        String path = "./src/main/resources/static/image/";
        String fileName = UUID.randomUUID().toString() + ".jpg";
        if (upload(request, path, fileName)) {
            return "/image/" + fileName;
        } else {
            return null;
        }
    }

    /**
     * 上传视频
     *
     * @param request 请求对象
     * @return String
     */
    @Override
    public String uploadVideo(HttpServletRequest request) {
        String path="./src/main/resources/static/video/";
        String fileName = UUID.randomUUID().toString() + ".mp4";

        if (upload(request, path, fileName)) {
            return "/video/" + fileName;
        } else {
            return null;
        }
    }

    /**
     * 解析请求对象
     *
     * @param request 请求对象
     * @param path 保存路径
     * @param fileName 保存文件名
     * @return boolean
     */
    private boolean upload(HttpServletRequest request, String path,String fileName) {
        File file = new File(path);
        if (!file.exists()) {
            boolean bool = file.mkdirs();
            if (!bool) {
                return false;
            }
        }

        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                InputStream in = part.getInputStream();
                OutputStream out = new FileOutputStream(path + fileName);

                int len;
                byte[] buffer = new byte[1024 * 1024];
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }

                out.flush();
                out.close();
                in.close();
            }

            return true;
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            return false;
        }
    }
}
