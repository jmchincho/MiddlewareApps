package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategories;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubCategoriesRepository {

    Page<Subcategories> findAll(Subcategories subcategories);

    Subcategories findById(Long id);

    void insert(Subcategories subcategories);

    void update(Subcategories subcategories);

    void delete(Long id);
    
}