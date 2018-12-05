package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface SubcategoryService {

    List<Subcategory> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Subcategory get(Long id) throws CowException;

    void create(Subcategory subcategory) throws CowException;

    void update(Subcategory subcategory) throws CowException;

    void delete(Long id) throws CowException;

}
