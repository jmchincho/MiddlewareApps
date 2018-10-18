package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    Page<Item> find(Integer index, Integer totalCount,Item item) throws CowException;

    Item get(Long id) throws CowException;

    void create(Item item) throws CowException;

    void update(Item item) throws CowException;

    void delete(Long id) throws CowException;

}
