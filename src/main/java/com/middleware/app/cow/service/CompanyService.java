package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    Page<Company> find(Integer index, Integer totalCount,Company company) throws CowException;

    Company get(Long id) throws CowException;

    void create(Company company) throws CowException;

    void update(Company company) throws CowException;

    void delete(Long id) throws CowException;

}
