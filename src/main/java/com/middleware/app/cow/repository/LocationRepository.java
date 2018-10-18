package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Location;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationRepository {

    Page<Location> findAll(Location location) throws Exception;

    Location findById(Long id) throws Exception;

    void insert(Location location) throws Exception;

    void update(Location location) throws Exception;

    void delete(Long id) throws Exception;

}