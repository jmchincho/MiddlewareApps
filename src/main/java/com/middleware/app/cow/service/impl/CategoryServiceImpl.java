package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Page<Category> find(Integer index, Integer totalCount,Category Category) throws CowException {
        return null;
    }

    @Override
    public Category get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Category Category) throws CowException {

    }

    @Override
    public void update(Category Category) throws CowException {

    }

    @Override
    public void delete(Category Category) throws CowException {

    }
}
