package com.example.bdkj_website.service.impl;


import com.example.bdkj_website.entity.Information;
import com.example.bdkj_website.mapper.InformationMapper;
import com.example.bdkj_website.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    InformationMapper informationMapper;

    @Override
    public void testSave(Information announcement) {
        int i = informationMapper.insertSelective(announcement);
    }
}

