package com.example.bdkj_website.entity;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class Entrance {
    private Integer id;

    private String title;

    private String content;

    private String webSite;

    private Integer type;

    private String image;

    private Date beginDate;

    private Date endDate;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        Entrance entrance = new Entrance();
        entrance.setId(2);
        entrance.setBeginDate(new Date());
        entrance.setEndDate(new Date());
        entrance.setImage("aaaaaaa.jpg");
        entrance.setContent("内容");
        entrance.setTitle("标题");
        entrance.setType(20);
        entrance.setWebSite("链接地址");
        System.out.println(JSON.toJSONString(entrance));
        //{"beginDate":1623380964087,"content":"内容","endDate":1623380964087,"id":2,"image":"aaaaaaa.jpg","title":"标题","type":20,"webSite":"链接地址"}
    }
}