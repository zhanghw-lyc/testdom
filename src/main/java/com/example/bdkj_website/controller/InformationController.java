package com.example.bdkj_website.controller;

import com.alibaba.fastjson.JSON;
import com.example.bdkj_website.constant.OperationMessageConstant;
import com.example.bdkj_website.entity.Information;
import com.example.bdkj_website.modol.StandardData;
import com.example.bdkj_website.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhanghw
 */
@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    InformationService informationService;


    @RequestMapping(value = "/saveInformation.do",method = RequestMethod.POST)
    public StandardData saveInformation(@RequestParam String informationStr) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._save_success);
        try {
            Information information = JSON.parseObject(informationStr, Information.class);
            int update = informationService.saveInformation(information);
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

    @RequestMapping(value = "/getInformationList.do",method = RequestMethod.POST)
    public StandardData getInformationList() {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._load_success);
        try {
            List<Information> informationList = informationService.getInformationList();
            result.put("informationList",informationList);
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._load_failed);
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/deleteInformationById.do",method = RequestMethod.POST)
    public StandardData deleteInformationById(@RequestParam Integer id) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._operate_success_waiting);
        try {
            int delete = informationService.deleteInformationById(id);
            if (delete != 1){
                result.setError(OperationMessageConstant._operate__failed);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._operate_success_waiting);
            return result;
        }
        return result;
    }
}
