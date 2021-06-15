package com.example.bdkj_website.entity;

import com.alibaba.fastjson.JSON;

public class Information {
    private Integer id;

    private String title;

    private String content;

    private String webSite;

    private String image;

    private String att1;

    private String att2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
        Information information = new Information();
        information.setContent("内容");
        information.setImage("aaaaaa.jpg");
        information.setTitle("标题");
        information.setWebSite("官网");
        System.out.println(JSON.toJSONString(information));
        //{"content":"内容","image":"aaaaaa.jpg","title":"标题","webSite":"官网"}
    }
}