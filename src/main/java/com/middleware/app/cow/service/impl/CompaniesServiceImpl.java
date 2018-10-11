package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Companies;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CompaniesService;
import org.springframework.stereotype.Service;

@Service
public class CompaniesServiceImpl implements CompaniesService {

    @Override
    public Page<Companies> find(Companies companies) throws CowException {
        return null;
    }

    @Override
    public Companies get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Companies companies) throws CowException {

    }

    @Override
    public void update(Companies companies) throws CowException {

    }

    @Override
    public void delete(Companies companies) throws CowException {

    }
}
