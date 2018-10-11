package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Locations;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.LocationsService;
import org.springframework.stereotype.Service;

@Service
public class LocationsServiceImpl implements LocationsService {

    @Override
    public Page<Locations> find(Locations locations) throws CowException {
        return null;
    }

    @Override
    public Locations get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Locations locations) throws CowException {

    }

    @Override
    public void update(Locations locations) throws CowException {

    }

    @Override
    public void delete(Locations locations) throws CowException {

    }
}
