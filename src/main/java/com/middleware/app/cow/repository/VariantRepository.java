package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Variant;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VariantRepository {

    Page<Variant> findAll(Variant Variant) throws Exception;

    Variant findById(Long id) throws Exception;

    void insert(Variant Variant) throws Exception;

    void update(Variant Variant) throws Exception;

    void delete(Long id) throws Exception;
}