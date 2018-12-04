package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    List<Category> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Category get(Long id) throws CowException;

    void create(Category category) throws CowException;

    void update(Category category) throws CowException;

    void delete(Long id) throws CowException;

}
