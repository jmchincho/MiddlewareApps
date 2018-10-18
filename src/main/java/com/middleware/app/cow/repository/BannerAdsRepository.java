package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.BannerAds;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerAdsRepository {

    Page<BannerAds> findAll(BannerAds bannerAds) throws Exception;

    BannerAds findById(Long id) throws Exception;

    void insert(BannerAds bannerAds) throws Exception;

    void update(BannerAds bannerAds) throws Exception;

    void delete(Long id) throws Exception;

}