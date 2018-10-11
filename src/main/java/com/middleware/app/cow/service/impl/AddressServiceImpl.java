package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.AddressService;
import org.springframework.stereotype.Service;


public class AddressServiceImpl implements AddressService {

    @Override
    public Page<Address> find(Address address) throws CowException {
        return null;
    }

    @Override
    public Address get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Address address) throws CowException {

    }

    @Override
    public void update(Address address) throws CowException {

    }

    @Override
    public void delete(Address address) throws CowException {

    }
}
