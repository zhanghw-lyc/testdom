package com.example.bdkj_website.service;

import com.example.bdkj_website.entity.Entrance;

import java.util.List;

public interface EntranceService {

    int saveEntrance(Entrance entrance);

    List<Entrance> getEntranceList(String isTop);

    int deleteEntranceById(Integer id);

    int topEntrance(Integer id);

}
