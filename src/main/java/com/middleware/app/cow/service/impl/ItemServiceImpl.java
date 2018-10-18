package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public Page<Item> find(Integer index, Integer totalCount,Item item) throws CowException {
        return null;
    }

    @Override
    public Item get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Item item) throws CowException {

    }

    @Override
    public void update(Item item) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
