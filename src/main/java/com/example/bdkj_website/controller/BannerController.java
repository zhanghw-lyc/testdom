package com.example.bdkj_website.controller;

import com.alibaba.fastjson.JSON;
import com.example.bdkj_website.constant.OperationMessageConstant;
import com.example.bdkj_website.entity.Banner;
import com.example.bdkj_website.modol.StandardData;
import com.example.bdkj_website.service.BannerService;
import com.example.bdkj_website.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bdkj_website
 * @description: 轮训图controller
 * @author: zhanghw
 * @create: 2021-06-11 09:29
 **/
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    TestService testService;

    @Autowired
    BannerService bannerService;


    @RequestMapping(value = "/saveBanner.do",method = RequestMethod.POST)
    public StandardData saveBanner(@RequestParam String bannerStr) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._save_success);
        try {
            //String str = "{\"id\":1,\"image\":\"aaaaaaa.jpg\",\"webSite\":\"www.baidu.com\"}";
            Banner banner = JSON.parseObject(bannerStr, Banner.class);
            int update = bannerService.saveBanner(banner);
            if (update != 1){
                result.setError(OperationMessageConstant._save_failed);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._save_failed);
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/getBannerList.do",method = RequestMethod.POST)
    public StandardData getBannerList() {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._load_success);
        try {
            List<Banner> bannerList = bannerService.getBannerList();
            result.put("bannerList",bannerList);
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._load_failed);
            return result;
        }
        return result;
    }
}
