package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Variants;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.VariantsService;
import org.springframework.stereotype.Service;

@Service
public class VariantsServiceImpl implements VariantsService {

    @Override
    public Page<Variants> find(Variants variants) throws CowException {
        return null;
    }

    @Override
    public Variants get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Variants variants) throws CowException {

    }

    @Override
    public void update(Variants variants) throws CowException {

    }

    @Override
    public void delete(Variants variants) throws CowException {

    }
}
