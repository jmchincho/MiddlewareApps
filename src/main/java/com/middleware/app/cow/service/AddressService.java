package com.middleware.app.cow.service;


import java.util.List;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;

public interface AddressService {

    List<Address> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Address get(Long id) throws CowException;

    void create(Address address) throws CowException;

    void update(Address address) throws CowException;

    void delete(Long id) throws CowException;

}
