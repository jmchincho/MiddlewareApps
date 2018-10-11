package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Items;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ItemsService;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Override
    public Page<Items> find(Items items) throws CowException {
        return null;
    }

    @Override
    public Items get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Items items) throws CowException {

    }

    @Override
    public void update(Items items) throws CowException {

    }

    @Override
    public void delete(Items items) throws CowException {

    }
}
