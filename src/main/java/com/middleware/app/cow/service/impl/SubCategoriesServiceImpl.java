package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategories;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.SubCategoriesService;
import org.springframework.stereotype.Service;

@Service
public class SubCategoriesServiceImpl implements SubCategoriesService {

    @Override
    public Page<Subcategories> find(Subcategories subcategories) throws CowException {
        return null;
    }

    @Override
    public Subcategories get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Subcategories subcategories) throws CowException {

    }

    @Override
    public void update(Subcategories subcategories) throws CowException {

    }

    @Override
    public void delete(Subcategories subcategories) throws CowException {

    }
}
