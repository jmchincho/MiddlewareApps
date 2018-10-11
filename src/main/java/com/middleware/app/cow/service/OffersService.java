package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Offers;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OffersService {

    Page<Offers> find(Offers offers) throws CowException;

    Offers get(Long id) throws CowException;

    void create(Offers offers) throws CowException;

    void update(Offers offers) throws CowException;

    void delete(Offers offers) throws CowException;

}
