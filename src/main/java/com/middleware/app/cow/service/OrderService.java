package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    List<Order> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Order get(Long id) throws CowException;

    void create(Order order) throws CowException;

    void update(Order order) throws CowException;

    void delete(Long id) throws CowException;

}
