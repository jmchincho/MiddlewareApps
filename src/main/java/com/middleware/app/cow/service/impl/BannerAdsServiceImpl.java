package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.BannerAdsRepository;
import com.middleware.app.cow.service.BannerAdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerAdsServiceImpl implements BannerAdsService {

    @Autowired
    private BannerAdsRepository bannerAdsRepository;

    public BannerAdsServiceImpl(BannerAdsRepository bannerAdsRepository) {
        this.bannerAdsRepository = bannerAdsRepository;
    }

    @Override
    public Page<BannerAds> find(Integer index, Integer totalCount,BannerAds bannerAds) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return  bannerAdsRepository.findAll(bannerAds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public BannerAds get(Long id) throws CowException {
        try {
            return bannerAdsRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(BannerAds bannerAds) throws CowException {
        try {
            bannerAdsRepository.insert(bannerAds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(BannerAds bannerAds) throws CowException {
        try {
            bannerAdsRepository.update(bannerAds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            bannerAdsRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
