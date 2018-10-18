package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryRepository {

    Page<Country> findAll(Country country) throws Exception;

    Country findById(Long id) throws Exception;

    void insert(Country country) throws Exception;

    void update(Country country) throws Exception;

    void delete(Long id) throws Exception;

}