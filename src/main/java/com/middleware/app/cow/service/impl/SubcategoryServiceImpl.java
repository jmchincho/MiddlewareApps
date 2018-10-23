package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.SubcategoryRepository;
import com.middleware.app.cow.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Page<Subcategory> find(Integer index, Integer totalCount,Subcategory subcategory) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return subcategoryRepository.findAll(subcategory);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Subcategory get(Long id) throws CowException {
        try {
            return subcategoryRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Subcategory subcategory) throws CowException {
        try {
            subcategoryRepository.insert(subcategory);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Subcategory subcategory) throws CowException {
        try {
            subcategoryRepository.update(subcategory);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            subcategoryRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
