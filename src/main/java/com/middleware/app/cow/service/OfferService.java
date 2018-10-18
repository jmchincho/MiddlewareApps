package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {

    Page<Offer> find(Integer index, Integer totalCount,Offer offer) throws CowException;

    Offer get(Long id) throws CowException;

    void create(Offer offer) throws CowException;

    void update(Offer offer) throws CowException;

    void delete(Long id) throws CowException;

}
