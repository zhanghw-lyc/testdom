package com.example.bdkj_website.vo;

/**
 * @program: BDcjrh
 * @description: 图片对象
 * @author: zhanghw
 * @create: 2020-11-27 12:29
 **/
public class ImageVo {

    private String picName;//文件名

    private String originPath;//原图路径

    private String originHttpPath;

    public String getOriginHttpPath() {
        return originHttpPath;
    }

    public void setOriginHttpPath(String originHttpPath) {
        this.originHttpPath = originHttpPath;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getOriginPath() {
        return originPath;
    }

    public void setOriginPath(String originPath) {
        this.originPath = originPath;
    }
}
