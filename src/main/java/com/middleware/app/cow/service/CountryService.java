package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {

    Page<Country> find(Integer index, Integer totalCount,Country country) throws CowException;

    Country get(Long id) throws CowException;

    void create(Country country) throws CowException;

    void update(Country country) throws CowException;

    void delete(Long id) throws CowException;

}
