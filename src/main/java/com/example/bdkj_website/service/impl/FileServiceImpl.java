package com.example.bdkj_website.service.impl;

import com.example.bdkj_website.constant.FileMessageConstant;
import com.example.bdkj_website.exception.BDException;
import com.example.bdkj_website.service.FileService;
import com.example.bdkj_website.tools.BDFileUtil;
import com.example.bdkj_website.tools.BDRandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhanghw
 * @date 2020/2020/5/19/10:00
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    BDFileUtil bdFileUtil;

    @Override
    public String uploadImageStr(MultipartFile image, String requestHead) throws Exception {
        try {
            //校验附件格式
            validImg(image);
            String imgName = image.getOriginalFilename();// 获取文件名
            String suffixName = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String newFileName = BDRandomUtils.uuid() + suffixName;
            //上传附件到服务器
            handleFileUploadBase64(image, newFileName);
            return newFileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String uploadSingleImage(MultipartFile image, String requestHead) throws IOException {
        try {
            //校验附件格式
            validImg(image);
            String imgName = image.getOriginalFilename();// 获取文件名
            String suffixName = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String newFileName = BDRandomUtils.uuid() + suffixName;
            //上传附件到服务器
            handleFileUploadBase64(image, newFileName);
            return newFileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteImage(String imageName) {
        String path = bdFileUtil.getFilePath() + "/" + imageName;
        File file = new File(path);
        if (file.exists() && file.isFile()){
            file.delete();
        }
    }

    /**
     * 校验图片
     *
     * @param file
     */
    private int validImg(MultipartFile file)  {
        if (file == null) {
            return -1;
        }
        String imgName = file.getOriginalFilename();// 获取文件名
        Long imgSize = file.getSize();
        //校验附件格式
        if (imgName.contains(".")) {
            // 获取文件后缀并转化为小写
            String suffixName = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            if (!suffixName.toLowerCase().equals(".png") && !suffixName.toLowerCase().equals(".jpg") && !suffixName.toLowerCase().equals(".jpeg")) {
                throw new BDException(FileMessageConstant._file_suffix_not_correct);
            }
        } else {// 文件没有后缀,文件有错误
            throw new BDException(FileMessageConstant._file_suffix_missed);
        }
        // 文件过大
        if (imgSize > FileMessageConstant._img_size_task_max) {
            throw new BDException(FileMessageConstant._img_task_size_out_of_max);
        }
        return 0;
    }

    /**
     * 附件上传到服务器
     * @param file
     * @param newFileName
     * @throws IOException
     */
    private void handleFileUploadBase64(MultipartFile file, String newFileName) throws IOException {
        // 文件对象
        String originImagePath = bdFileUtil.getFilePath();
        String path = originImagePath+"/"+newFileName;
        File dest = new File(path);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        byte[] bytes = file.getBytes();
        OutputStream out = new FileOutputStream(dest);
        out.write(bytes);
        out.flush();
        out.close();//由于transfer的方式无法关闭流，故换成此方式，主动关闭流
    }

}
