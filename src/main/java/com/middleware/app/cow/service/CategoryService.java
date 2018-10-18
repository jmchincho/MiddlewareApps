package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    Page<Category> find(Integer index, Integer totalCount,Category category) throws CowException;

    Category get(Long id) throws CowException;

    void create(Category category) throws CowException;

    void update(Category category) throws CowException;

    void delete(Long id) throws CowException;

}
