package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    List<Company> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Company get(Long id) throws CowException;

    Long create(Company company) throws CowException;

    void update(Company company) throws CowException;

    void delete(Long id) throws CowException;

}
