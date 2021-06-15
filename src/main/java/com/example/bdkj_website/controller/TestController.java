package com.example.bdkj_website.controller;

import com.alibaba.fastjson.JSON;
import com.example.bdkj_website.constant.OperationMessageConstant;
import com.example.bdkj_website.entity.Information;
import com.example.bdkj_website.modol.StandardData;
import com.example.bdkj_website.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghw
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;


    @RequestMapping(value = "/testSave.do",method = RequestMethod.POST)
    public StandardData testSave() {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._load_success);
        try {
            String str = "{\"content\":\"123123123\",\"title\":\"公告\"}";
            Information information = JSON.parseObject(str, Information.class);
            testService.testSave(information);
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._load_failed);
            return result;
        }
        return result;
    }


}
