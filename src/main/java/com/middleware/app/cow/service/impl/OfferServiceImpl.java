package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OfferRepository;
import com.middleware.app.cow.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Page<Offer> find(Integer index, Integer totalCount,Offer offer) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return offerRepository.findAll(offer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Offer get(Long id) throws CowException {
        try {
            return offerRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Offer offer) throws CowException {
        try {
            offerRepository.insert(offer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Offer offer) throws CowException {
        try {
            offerRepository.update(offer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            offerRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
