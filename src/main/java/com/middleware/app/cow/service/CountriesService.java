package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Countries;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CountriesService {

    Page<Countries> find(Countries countries) throws CowException;

    Countries get(Long id) throws CowException;

    void create(Countries countries) throws CowException;

    void update(Countries countries) throws CowException;

    void delete(Countries countries) throws CowException;

}
