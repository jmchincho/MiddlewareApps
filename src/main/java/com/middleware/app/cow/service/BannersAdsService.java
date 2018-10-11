package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Bannerads;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface BannersAdsService {

    Page<Bannerads> find(Bannerads bannerads) throws CowException;

    Bannerads get(Long id) throws CowException;

    void create(Bannerads bannerads) throws CowException;

    void update(Bannerads bannerads) throws CowException;

    void delete(Bannerads bannerads) throws CowException;

}
