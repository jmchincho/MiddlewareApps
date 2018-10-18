package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.BannerAdsService;
import org.springframework.stereotype.Service;

@Service
public class BannerAdsServiceImpl implements BannerAdsService {
    @Override
    public Page<BannerAds> find(Integer index, Integer totalCount,BannerAds bannerAds) throws CowException {
        return null;
    }

    @Override
    public BannerAds get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(BannerAds bannerAds) throws CowException {

    }

    @Override
    public void update(BannerAds bannerAds) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
