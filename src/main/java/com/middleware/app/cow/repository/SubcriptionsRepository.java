package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubcriptionsRepository {

    Page<Subcription> findAll(Subcription subcription);

    Subcription findById(Long id);

    void insert(Subcription subcription);

    void update(Subcription subcription);

    void delete(Long id);
    
}