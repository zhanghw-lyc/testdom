package com.example.bdkj_website.service.impl;


import com.example.bdkj_website.entity.Banner;
import com.example.bdkj_website.entity.BannerExample;
import com.example.bdkj_website.mapper.BannerMapper;
import com.example.bdkj_website.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;


    @Override
    public int saveBanner(Banner banner) {
        int update = bannerMapper.updateByPrimaryKeySelective(banner);
        return update;
    }

    @Override
    public List<Banner> getBannerList() {
        BannerExample bannerExample = new BannerExample();
        bannerExample.setOrderByClause("id asc");
        List<Banner> bannerList = bannerMapper.selectByExample(bannerExample);
        return bannerList;
    }
}

