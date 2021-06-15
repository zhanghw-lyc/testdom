package com.example.bdkj_website.controller;

import com.alibaba.fastjson.JSON;
import com.example.bdkj_website.constant.OperationMessageConstant;
import com.example.bdkj_website.entity.Entrance;
import com.example.bdkj_website.modol.StandardData;
import com.example.bdkj_website.service.EntranceService;
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
@RequestMapping("/entrance")
public class EntranceController {

    @Autowired
    EntranceService entranceService;


    /**
     * 保存报名入口
     * @param entranceStr
     * @return
     */
    @RequestMapping(value = "/saveEntrance.do",method = RequestMethod.POST)
    public StandardData saveEntrance(@RequestParam String entranceStr) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._save_success);
        try {
            Entrance entrance = JSON.parseObject(entranceStr, Entrance.class);
            int update = entranceService.saveEntrance(entrance);
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

    /**
     * 查询报名入口列表
     * @return
     */
    @RequestMapping(value = "/getEntranceList.do",method = RequestMethod.POST)
    public StandardData getEntranceList(@RequestParam String isTop) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._save_success);
        try {
            List<Entrance> entranceList = entranceService.getEntranceList(isTop);
            result.put("entranceList",entranceList);
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._save_failed);
            return result;
        }
        return result;
    }

    /**
     * 删除报名入口
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteEntranceById.do",method = RequestMethod.POST)
    public StandardData deleteEntranceById(@RequestParam Integer id) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._operate_success_waiting);
        try {
            int delete = entranceService.deleteEntranceById(id);
            if (delete != 1){
                result.setError(OperationMessageConstant._operate__failed);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._operate__failed);
            return result;
        }
        return result;
    }

    /**
     * 报名入口：置顶
     * @param id
     * @return
     */
    @RequestMapping(value = "/topEntrance.do",method = RequestMethod.POST)
    public StandardData topEntrance(@RequestParam Integer id) {
        StandardData<String, Object> result = new StandardData<>();
        result.setSuccess(OperationMessageConstant._operate_success_waiting);
        try {
            int update = entranceService.topEntrance(id);
            if (update == -1){
                result.setError("最多置顶4个");
                return result;
            }
            if (update != 1){
                result.setError(OperationMessageConstant._operate__failed);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setError(OperationMessageConstant._operate__failed);
            return result;
        }
        return result;
    }

}
