package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.SubcategoryService;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Override
    public Page<Subcategory> find(Integer index, Integer totalCount,Subcategory subcategory) throws CowException {
        return null;
    }

    @Override
    public Subcategory get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Subcategory subcategory) throws CowException {

    }

    @Override
    public void update(Subcategory subcategory) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
