package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressRepository {

    Page<Address> findAll(Address address) throws Exception;

    Address findById(Long id) throws Exception;

    void insert(Address address) throws Exception;

    void update(Address address) throws Exception;

    void delete(Long id) throws Exception;

}