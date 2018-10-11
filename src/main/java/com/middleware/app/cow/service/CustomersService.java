package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Customers;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CustomersService {

    Page<Customers> find(Customers customers) throws CowException;

    Customers get(Long id) throws CowException;

    void create(Customers customers) throws CowException;

    void update(Customers customers) throws CowException;

    void delete(Customers customers) throws CowException;

}
