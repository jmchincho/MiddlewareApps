package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.AdministratorService;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Override
    public Page<Administrator> find(Integer index, Integer totalCount,Administrator administrator) throws CowException {
        return null;
    }

    @Override
    public Administrator get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Administrator administrator) throws CowException {

    }

    @Override
    public void update(Administrator administrator) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
