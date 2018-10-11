package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategories;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface SubCategoriesService {

    Page<Subcategories> find(Subcategories subcategories) throws CowException;

    Subcategories get(Long id) throws CowException;

    void create(Subcategories subcategories) throws CowException;

    void update(Subcategories subcategories) throws CowException;

    void delete(Subcategories subcategories) throws CowException;

}
