package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Orders;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OrdersService {

    Page<Orders> find(Orders orders) throws CowException;

    Orders get(Long id) throws CowException;

    void create(Orders orders) throws CowException;

    void update(Orders orders) throws CowException;

    void delete(Orders orders) throws CowException;

}
