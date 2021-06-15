package com.example.bdkj_website.service;

import com.example.bdkj_website.entity.Information;

import java.util.List;

public interface InformationService {

    int saveInformation(Information information);

    List<Information> getInformationList();

    int deleteInformationById(Integer id);

}
