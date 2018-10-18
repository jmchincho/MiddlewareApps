package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Page<Order> find(Integer index, Integer totalCount,Order order) throws CowException;

    Order get(Long id) throws CowException;

    void create(Order order) throws CowException;

    void update(Order order) throws CowException;

    void delete(Long id) throws CowException;

}
