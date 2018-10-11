package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Orders;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Override
    public Page<Orders> find(Orders orders) throws CowException {
        return null;
    }

    @Override
    public Orders get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Orders orders) throws CowException {

    }

    @Override
    public void update(Orders orders) throws CowException {

    }

    @Override
    public void delete(Orders orders) throws CowException {

    }
}
