package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {

    List<Offer> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Offer get(Long id) throws CowException;

    void create(Offer offer) throws CowException;

    void update(Offer offer) throws CowException;

    void delete(Long id) throws CowException;

}
