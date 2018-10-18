package com.middleware.app.cow.service;


import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;

public interface AddressService {

    Page<Address> find(Integer index, Integer totalCount, Address address) throws CowException;

    Address get(Long id) throws CowException;

    void create(Address address) throws CowException;

    void update(Address address) throws CowException;

    void delete(Long id) throws CowException;

}
