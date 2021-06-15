package com.example.bdkj_website.controller;

import com.example.bdkj_website.constant.OperationMessageConstant;
import com.example.bdkj_website.exception.BDException;
import com.example.bdkj_website.modol.StandardData;
import com.example.bdkj_website.service.FileService;
import com.example.bdkj_website.tools.BDBase64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: workspace_cjrhpt
 * @description: 文件及图片处理
 * @author: zhanghw
 * @create: 2021-03-03 15:36
 **/
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 根据base64串解析上传图片
     */
    @RequestMapping(value = "/uploadImageStr.do",method = RequestMethod.POST)
    public StandardData uploadImageStr(HttpServletRequest request, @RequestParam String imageStr) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._upload_success);
        try {
            MultipartFile image = BDBase64Util.base64ToMultipart(imageStr);
            String requestHead = getRequestHead(request);
            String imageName = fileService.uploadImageStr(image,requestHead);
            result.put("imageName",imageName);
        } catch (Exception e) {
            result.setError(OperationMessageConstant._operate__failed);
            return result;
        }
        return result;
    }


    /**
     * 获取图片映射头信息
     * @param request
     * @return
     */
    private String getRequestHead(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String requestHead = requestURL.substring(0, requestURL.indexOf(requestURI));
        return requestHead;
    }


    /**
     * 上传单个图片文件
     * @param request
     * @param image
     * @return
     */
    @PostMapping(value = "/uploadSingleImage.do", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public StandardData uploadSingleImage(HttpServletRequest request, @RequestParam MultipartFile image) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._upload_success);
        try {
            String requestHead = getRequestHead(request);
            String imageName = fileService.uploadSingleImage(image,requestHead);
            result.put("imageName",imageName);
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(OperationMessageConstant._operate__failed);
            return result;
        }
        return result;
    }

    /**
     * 删除图片
     * @param imageName
     * @return
     */
    @PostMapping(value = "/deleteImage.do")
    public StandardData deleteImage(@RequestParam String imageName) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._operate_success_waiting);
        try {
            fileService.deleteImage(imageName);
        } catch (BDException e) {
            e.printStackTrace();
            result.setError(OperationMessageConstant._operate__failed);
            return result;
        }
        return result;
    }


}
