package com.example.bdkj_website.service;

import com.example.bdkj_website.entity.Banner;

import java.util.List;

public interface BannerService {

    List<Banner> getBannerList();

    int saveBanner(Banner banner);

}
