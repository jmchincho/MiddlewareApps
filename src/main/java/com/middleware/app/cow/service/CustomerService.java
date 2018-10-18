package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Page<Customer> find(Integer index, Integer totalCount,Customer customer) throws CowException;

    Customer get(Long id) throws CowException;

    void create(Customer customer) throws CowException;

    void update(Customer customer) throws CowException;

    void delete(Long id) throws CowException;

}
