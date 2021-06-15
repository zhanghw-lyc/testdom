package com.example.bdkj_website.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhanghw
 * @date 2020/2020/5/19/10:00
 */
public interface FileService {

    String uploadSingleImage(MultipartFile image, String requestHead) throws IOException;

    String uploadImageStr(MultipartFile image, String requestHead) throws Exception;

    void deleteImage(String imageName);

}
