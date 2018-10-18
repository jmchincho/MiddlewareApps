package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Page<Order> find(Integer index, Integer totalCount,Order order) throws CowException {
        return null;
    }

    @Override
    public Order get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Order order) throws CowException {

    }

    @Override
    public void update(Order order) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
