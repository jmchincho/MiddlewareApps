package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.LocationRepository;
import com.middleware.app.cow.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Page<Location> find(Integer index, Integer totalCount,Location location) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return locationRepository.findAll(location);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Location get(Long id) throws CowException {
        try {
            return locationRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Location location) throws CowException {
        try {
            locationRepository.insert(location);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Location location) throws CowException {
        try {
            locationRepository.update(location);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            locationRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
