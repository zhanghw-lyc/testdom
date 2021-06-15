package com.example.bdkj_website.entity;

import com.alibaba.fastjson.JSON;

public class Banner {
    private Integer id;

    private String image;

    private String webSite;

    private String att1;

    private String att2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1 == null ? null : att1.trim();
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt2(String att2) {
        this.att2 = att2 == null ? null : att2.trim();
    }

    public static void main(String[] args) {
        Banner banner = new Banner();
        banner.setId(1);
        banner.setImage("aaaaaaa.jpg");
        banner.setWebSite("www.baidu.com");
        System.out.println(JSON.toJSONString(banner));
        //{"id":1,"image":"aaaaaaa.jpg","webSite":"www.baidu.com"}
    }
}