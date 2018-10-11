package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Companies;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CompaniesService {

    Page<Companies> find(Companies companies) throws CowException;

    Companies get(Long id) throws CowException;

    void create(Companies companies) throws CowException;

    void update(Companies companies) throws CowException;

    void delete(Companies companies) throws CowException;

}
