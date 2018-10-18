package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Page<Category> find(Integer index, Integer totalCount,Category category) throws CowException {
        return null;
    }

    @Override
    public Category get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Category category) throws CowException {

    }

    @Override
    public void update(Category category) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
