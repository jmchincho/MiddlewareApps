package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Bannerads;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.BannersAdsService;
import org.springframework.stereotype.Service;

@Service
public class BannersAdsServiceImpl implements BannersAdsService {
    @Override
    public Page<Bannerads> find(Bannerads bannerads) throws CowException {
        return null;
    }

    @Override
    public Bannerads get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Bannerads bannerads) throws CowException {

    }

    @Override
    public void update(Bannerads bannerads) throws CowException {

    }

    @Override
    public void delete(Bannerads bannerads) throws CowException {

    }
}
