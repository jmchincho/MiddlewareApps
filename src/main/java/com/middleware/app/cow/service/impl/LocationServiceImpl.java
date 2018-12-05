package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.LocationRepository;
import com.middleware.app.cow.service.LocationService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Location.class.getSimpleName());

            return locationRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
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
