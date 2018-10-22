package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {

    Page<Administrator> find(Integer index, Integer totalCount,Administrator Administrator) throws CowException;

    Administrator get(Long id) throws CowException;

    Long create(Administrator Administrator) throws CowException;

    void update(Administrator Administrator) throws CowException;

    void delete(Long id) throws CowException;

}
