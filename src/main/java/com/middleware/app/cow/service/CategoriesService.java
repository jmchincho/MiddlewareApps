package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Categories;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CategoriesService {

    Page<Categories> find(Categories categories) throws CowException;

    Categories get(Long id) throws CowException;

    void create(Categories categories) throws CowException;

    void update(Categories categories) throws CowException;

    void delete(Categories categories) throws CowException;

}
