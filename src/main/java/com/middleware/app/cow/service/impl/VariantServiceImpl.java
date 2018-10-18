package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.VariantService;
import org.springframework.stereotype.Service;

@Service
public class VariantServiceImpl implements VariantService {

    @Override
    public Page<Variant> find(Integer index, Integer totalCount,Variant Variant) throws CowException {
        return null;
    }

    @Override
    public Variant get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Variant variant) throws CowException {

    }

    @Override
    public void update(Variant variant) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
