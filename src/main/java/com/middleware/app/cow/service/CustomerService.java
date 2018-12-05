package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    List<Customer> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Customer get(Long id) throws CowException;

    Long create(Customer customer) throws CowException;

    void update(Customer customer) throws CowException;

    void delete(Long id) throws CowException;

}
