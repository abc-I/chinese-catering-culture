package org.bearer.service.impl;

import org.bearer.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
     * @param file 文件保存对象
     * @return String
     */
    @Override
    public String uploadPicture(MultipartFile file) {
        String path = "/home/static/image/";
        return "/static/image/" + upload(file, path);
    }

    /**
     * 上传视频
     *
     * @param file 文件保存对象
     * @return String
     */
    @Override
    public String uploadVideo(MultipartFile file) {
        String path="/home/static/video/";
        return "/static/video/" + upload(file, path);
    }

    /**
     * 解析请求对象
     *
     * @param file 文件保存对象
     * @param path 保存路径
     * @return boolean
     */
    private String upload(MultipartFile file, String path) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String name = file.getOriginalFilename();

        String suffix = null;
        if (name != null) {
            suffix = name.substring(name.lastIndexOf("."));
        }

        String fileName = UUID.randomUUID().toString().replace("-", "") + suffix;

        File placeFile = new File(path);
        if (!placeFile.exists()) {
            placeFile.mkdirs();
        }

        try (
                InputStream in = file.getInputStream();
                OutputStream out = new FileOutputStream(path + fileName)
        ) {
            int len;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return fileName;
        }
    }
}
