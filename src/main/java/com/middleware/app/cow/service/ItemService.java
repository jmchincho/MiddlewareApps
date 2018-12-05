package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    List<Item> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Item get(Long id) throws CowException;

    void create(Item item) throws CowException;

    void update(Item item) throws CowException;

    void delete(Long id) throws CowException;

}
