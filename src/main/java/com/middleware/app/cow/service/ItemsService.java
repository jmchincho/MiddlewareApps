package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Items;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface ItemsService {

    Page<Items> find(Items items) throws CowException;

    Items get(Long id) throws CowException;

    void create(Items items) throws CowException;

    void update(Items items) throws CowException;

    void delete(Items items) throws CowException;

}
