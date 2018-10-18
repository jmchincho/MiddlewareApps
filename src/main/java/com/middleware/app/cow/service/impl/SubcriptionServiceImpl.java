package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.SubcriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubcriptionServiceImpl implements SubcriptionService {

    @Override
    public Page<Subcription> find(Integer index, Integer totalCount,Subcription subcription) throws CowException {
        return null;
    }

    @Override
    public Subcription get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Subcription subcription) throws CowException {

    }

    @Override
    public void update(Subcription subcription) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
