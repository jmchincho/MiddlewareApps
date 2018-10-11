package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.OrdersDetails;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {

    Page<OrdersDetails> find(OrdersDetails ordersDetails) throws CowException;

    OrdersDetails get(Long id) throws CowException;

    void create(OrdersDetails ordersDetails) throws CowException;

    void update(OrdersDetails ordersDetails) throws CowException;

    void delete(OrdersDetails ordersDetails) throws CowException;

}
