package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface SubcategoryService {

    Page<Subcategory> find(Integer index, Integer totalCount,Subcategory subcategory) throws CowException;

    Subcategory get(Long id) throws CowException;

    void create(Subcategory subcategory) throws CowException;

    void update(Subcategory subcategory) throws CowException;

    void delete(Long id) throws CowException;

}
