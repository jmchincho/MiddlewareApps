package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ProvinceService;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Override
    public Page<Province> find(Integer index, Integer totalCount,Province province) throws CowException {
        return null;
    }

    @Override
    public Province get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Province province) throws CowException {

    }

    @Override
    public void update(Province province) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
