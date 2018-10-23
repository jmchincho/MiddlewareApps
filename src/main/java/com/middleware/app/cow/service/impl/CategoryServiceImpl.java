package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CategoryRepository;
import com.middleware.app.cow.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> find(Integer index, Integer totalCount,Category category) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return categoryRepository.findAll(category);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Category get(Long id) throws CowException {
        try {
            return categoryRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Category category) throws CowException {
        try {
            categoryRepository.insert(category);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Category category) throws CowException {
        try {
            categoryRepository.update(category);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            categoryRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
