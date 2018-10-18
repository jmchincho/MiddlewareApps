package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    @Override
    public Page<Offer> find(Integer index, Integer totalCount,Offer offer) throws CowException {
        return null;
    }

    @Override
    public Offer get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Offer offer) throws CowException {

    }

    @Override
    public void update(Offer offer) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
