package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyRepository {

    Page<Company> findAll(Company address) throws Exception;

    Company findById(Long id) throws Exception;

    void insert(Company address) throws Exception;

    void update(Company address) throws Exception;

    void delete(Long id) throws Exception;

}