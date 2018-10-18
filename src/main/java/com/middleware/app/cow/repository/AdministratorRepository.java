package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Administrator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorRepository {

    Page<Administrator> findAll(Administrator administrator) throws Exception;

    Administrator findById(Long id) throws Exception;

    void insert(Administrator administrator) throws Exception;

    void update(Administrator administrator) throws Exception;

    void delete(Long id) throws Exception;

}