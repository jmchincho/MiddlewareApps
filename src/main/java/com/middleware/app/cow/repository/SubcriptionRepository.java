package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubcriptionRepository {

    Page<Subcription> findAll(Subcription subcription) throws Exception;

    Subcription findById(Long id) throws Exception;

    void insert(Subcription subcription) throws Exception;

    void update(Subcription subcription) throws Exception;

    void delete(Long id) throws Exception;
    
}