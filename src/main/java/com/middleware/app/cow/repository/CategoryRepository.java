package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryRepository {

    Page<Category> findAll(Category category) throws Exception;

    Category findById(Long id) throws Exception;

    void insert(Category category) throws Exception;

    void update(Category category) throws Exception;

    void delete(Long id) throws Exception;

}