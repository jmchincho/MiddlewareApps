package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemRepository {

    Page<Item> findAll(Item item) throws Exception;

    Item findById(Long id) throws Exception;

    void insert(Item item) throws Exception;

    void update(Item item) throws Exception;

    void delete(Long id) throws Exception;

}