package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.OrdersDetails;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OrderDetailsService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Override
    public Page<OrdersDetails> find(OrdersDetails ordersDetails) throws CowException {
        return null;
    }

    @Override
    public OrdersDetails get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(OrdersDetails ordersDetails) throws CowException {

    }

    @Override
    public void update(OrdersDetails ordersDetails) throws CowException {

    }

    @Override
    public void delete(OrdersDetails ordersDetails) throws CowException {

    }
}
