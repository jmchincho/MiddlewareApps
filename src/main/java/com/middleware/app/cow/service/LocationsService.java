package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Locations;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface LocationsService {

    Page<Locations> find(Locations locations) throws CowException;

    Locations get(Long id) throws CowException;

    void create(Locations locations) throws CowException;

    void update(Locations locations) throws CowException;

    void delete(Locations locations) throws CowException;

}
