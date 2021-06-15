package com.example.bdkj_website.service.impl;


import com.example.bdkj_website.entity.Entrance;
import com.example.bdkj_website.entity.EntranceExample;
import com.example.bdkj_website.mapper.EntranceMapper;
import com.example.bdkj_website.service.EntranceService;
import com.example.bdkj_website.tools.BDStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntranceServiceImpl implements EntranceService {

    @Autowired
    EntranceMapper entranceMapper;

    @Override
    public int saveEntrance(Entrance entrance) {
        Integer id = entrance.getId();
        int update;
        if (id == null){
            update = entranceMapper.insertSelective(entrance);
        }else {
            update = entranceMapper.updateByPrimaryKeySelective(entrance);
        }
        return update;
    }

    @Override
    public List<Entrance> getEntranceList(String isTop) {
        EntranceExample entranceExample = new EntranceExample();
        if (BDStringUtil.isNotBlank(isTop)){
            entranceExample.createCriteria().andAtt1EqualTo(isTop);
        }
        List<Entrance> entranceList = entranceMapper.selectByExample(entranceExample);
        return entranceList;
    }

    @Override
    public int deleteEntranceById(Integer id) {
        int delete = entranceMapper.deleteByPrimaryKey(id);
        return delete;
    }

    @Override
    public int topEntrance(Integer id) {
        //查询已有置顶个数，如果超过4个，则不允许置顶
        EntranceExample entranceExample = new EntranceExample();
        entranceExample.createCriteria().andAtt1EqualTo("Y");
        long count = entranceMapper.countByExample(entranceExample);
        if (count >= 4){
            return -1;
        }
        Entrance entrance = new Entrance();
        entrance.setId(id);
        entrance.setAtt1("Y");
        int update = entranceMapper.updateByPrimaryKeySelective(entrance);
        return update;
    }
}

