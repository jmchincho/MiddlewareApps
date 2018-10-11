package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface AdministratosService {

    Page<Address> find(Address address) throws CowException;

    Address get(Long id) throws CowException;

    void create(Address address) throws CowException;

    void update(Address address) throws CowException;

    void delete(Address address) throws CowException;

}
