package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Categories;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CategoriesService;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Override
    public Page<Categories> find(Categories categories) throws CowException {
        return null;
    }

    @Override
    public Categories get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Categories categories) throws CowException {

    }

    @Override
    public void update(Categories categories) throws CowException {

    }

    @Override
    public void delete(Categories categories) throws CowException {

    }
}
