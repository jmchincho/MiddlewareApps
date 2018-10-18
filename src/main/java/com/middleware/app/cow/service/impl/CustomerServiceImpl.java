package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Page<Customer> find(Integer index, Integer totalCount,Customer customer) throws CowException {
        return null;
    }

    @Override
    public Customer get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Customer customer) throws CowException {

    }

    @Override
    public void update(Customer customer) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
