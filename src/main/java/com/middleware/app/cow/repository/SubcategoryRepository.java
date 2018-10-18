package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubcategoryRepository {

    Page<Subcategory> findAll(Subcategory Subcategory) throws Exception;

    Subcategory findById(Long id) throws Exception;

    void insert(Subcategory Subcategory) throws Exception;

    void update(Subcategory Subcategory) throws Exception;

    void delete(Long id) throws Exception;
    
}