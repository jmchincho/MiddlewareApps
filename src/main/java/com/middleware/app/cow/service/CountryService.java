package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {

    List<Country> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Country get(Long id) throws CowException;

    void create(Country country) throws CowException;

    void update(Country country) throws CowException;

    void delete(Long id) throws CowException;

}
