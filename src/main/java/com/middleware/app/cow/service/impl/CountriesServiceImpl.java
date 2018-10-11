package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Countries;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CountriesService;
import org.springframework.stereotype.Service;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Override
    public Page<Countries> find(Countries countries) throws CowException {
        return null;
    }

    @Override
    public Countries get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Countries countries) throws CowException {

    }

    @Override
    public void update(Countries countries) throws CowException {

    }

    @Override
    public void delete(Countries countries) throws CowException {

    }
}
