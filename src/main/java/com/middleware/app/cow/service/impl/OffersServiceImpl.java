package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Offers;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OffersService;
import org.springframework.stereotype.Service;

@Service
public class OffersServiceImpl implements OffersService {

    @Override
    public Page<Offers> find(Offers offers) throws CowException {
        return null;
    }

    @Override
    public Offers get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Offers offers) throws CowException {

    }

    @Override
    public void update(Offers offers) throws CowException {

    }

    @Override
    public void delete(Offers offers) throws CowException {

    }
}
