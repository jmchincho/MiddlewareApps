package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Variants;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VariantsRepository {

    Page<Variants> findAll(Variants variants);

    Variants findById(Long id);

    void insert(Variants variants);

    void update(Variants variants);

    void delete(Long id);
}