package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerRepository {

    Page<Customer> findAll(Customer customer) throws Exception;

    Customer findById(Long id) throws Exception;

    void insert(Customer customer) throws Exception;

    void update(Customer customer) throws Exception;

    void delete(Long id) throws Exception;

}