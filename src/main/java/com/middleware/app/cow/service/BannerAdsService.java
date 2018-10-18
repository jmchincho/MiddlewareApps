package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface BannerAdsService {

    Page<BannerAds> find(Integer index, Integer totalCount,BannerAds bannerAds) throws CowException;

    BannerAds get(Long id) throws CowException;

    void create(BannerAds bannerAds) throws CowException;

    void update(BannerAds bannerAds) throws CowException;

    void delete(Long id) throws CowException;

}
