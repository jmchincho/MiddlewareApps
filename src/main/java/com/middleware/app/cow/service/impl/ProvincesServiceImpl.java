package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Provinces;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ProvincesService;
import org.springframework.stereotype.Service;

@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Override
    public Page<Provinces> find(Provinces provinces) throws CowException {
        return null;
    }

    @Override
    public Provinces get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Provinces provinces) throws CowException {

    }

    @Override
    public void update(Provinces provinces) throws CowException {

    }

    @Override
    public void delete(Provinces provinces) throws CowException {

    }
}
