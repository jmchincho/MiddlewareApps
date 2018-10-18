package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Province;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvinceRepository {

    Page<Province> findAll(Province province) throws Exception;

    Province findById(Long id) throws Exception;

    void insert(Province province) throws Exception;

    void update(Province province) throws Exception;

    void delete(Long id) throws Exception;

}