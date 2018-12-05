package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface BannerAdsService {

    List<BannerAds> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    BannerAds get(Long id) throws CowException;

    void create(BannerAds bannerAds) throws CowException;

    void update(BannerAds bannerAds) throws CowException;

    void delete(Long id) throws CowException;

}
