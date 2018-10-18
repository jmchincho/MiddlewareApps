package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {

    Page<Location> find(Integer index, Integer totalCount,Location location) throws CowException;

    Location get(Long id) throws CowException;

    void create(Location location) throws CowException;

    void update(Location location) throws CowException;

    void delete(Long id) throws CowException;

}
