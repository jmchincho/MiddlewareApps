package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public Page<Country> find(Integer index, Integer totalCount,Country country) throws CowException {
        return null;
    }

    @Override
    public Country get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Country country) throws CowException {

    }

    @Override
    public void update(Country country) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
