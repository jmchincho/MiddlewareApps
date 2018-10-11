package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Customers;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CustomersService;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Override
    public Page<Customers> find(Customers customers) throws CowException {
        return null;
    }

    @Override
    public Customers get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Customers customers) throws CowException {

    }

    @Override
    public void update(Customers customers) throws CowException {

    }

    @Override
    public void delete(Customers customers) throws CowException {

    }
}
