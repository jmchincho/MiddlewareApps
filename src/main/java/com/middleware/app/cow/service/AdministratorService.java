package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {

    List<Administrator> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Administrator get(Long id) throws CowException;

    Long create(Administrator Administrator) throws CowException;

    void update(Administrator Administrator) throws CowException;

    void delete(Long id) throws CowException;

}
