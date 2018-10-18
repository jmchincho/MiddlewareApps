package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {

    Page<Order> findAll(Order order) throws Exception;

    Order findById(Long id) throws Exception;

    void insert(Order order) throws Exception;

    void update(Order order) throws Exception;

    void delete(Long id) throws Exception;

}