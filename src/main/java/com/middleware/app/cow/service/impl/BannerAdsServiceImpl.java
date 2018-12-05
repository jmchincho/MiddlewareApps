package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.BannerAdsRepository;
import com.middleware.app.cow.service.BannerAdsService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerAdsServiceImpl implements BannerAdsService {

    @Autowired
    private BannerAdsRepository bannerAdsRepository;

    public BannerAdsServiceImpl(BannerAdsRepository bannerAdsRepository) {
        this.bannerAdsRepository = bannerAdsRepository;
    }

    @Override
    public List<BannerAds> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(BannerAds.class.getSimpleName());

            return  bannerAdsRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
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
