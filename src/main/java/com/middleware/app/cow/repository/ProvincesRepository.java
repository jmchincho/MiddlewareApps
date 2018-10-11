package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvincesRepository {

    Page<Address> findAll(Address address);

    Address findById(Long id);

    void insert(Address address);

    void update(Address address);

    void delete(Long id);

}