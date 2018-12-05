package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {

    List<Location> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Location get(Long id) throws CowException;

    void create(Location location) throws CowException;

    void update(Location location) throws CowException;

    void delete(Long id) throws CowException;

}
