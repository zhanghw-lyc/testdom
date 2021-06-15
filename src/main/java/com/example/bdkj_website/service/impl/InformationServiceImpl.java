package com.example.bdkj_website.service.impl;


import com.example.bdkj_website.entity.Information;
import com.example.bdkj_website.entity.InformationExample;
import com.example.bdkj_website.mapper.InformationMapper;
import com.example.bdkj_website.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationMapper informationMapper;

    @Override
    public int saveInformation(Information information) {
        Integer id = information.getId();
        int update;
        if (id == null){
            update = informationMapper.insertSelective(information);
        }else {
            update = informationMapper.updateByPrimaryKeySelective(information);
        }
        return update;
    }

    @Override
    public List<Information> getInformationList() {
        List<Information> informationList = informationMapper.selectByExample(new InformationExample());
        return informationList;
    }

    @Override
    public int deleteInformationById(Integer id) {
        int delete = informationMapper.deleteByPrimaryKey(id);
        return delete;
    }
}

