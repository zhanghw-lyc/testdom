package com.example.bdkj_website.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BDFileUtil {

    @Value("${filePath}")
    private String filePath;

    /**
     * 获取文件上传路径
     *
     * @return
     */
    public String getFilePath() {
        // 文件保存路径
        return filePath;
    }
}
