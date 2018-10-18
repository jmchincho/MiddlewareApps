package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public Page<Company> find(Integer index, Integer totalCount,Company company) throws CowException {
        return null;
    }

    @Override
    public Company get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Company company) throws CowException {

    }

    @Override
    public void update(Company company) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
