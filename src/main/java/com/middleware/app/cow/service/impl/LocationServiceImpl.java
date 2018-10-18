package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Override
    public Page<Location> find(Integer index, Integer totalCount,Location location) throws CowException {
        return null;
    }

    @Override
    public Location get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Location location) throws CowException {

    }

    @Override
    public void update(Location location) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
