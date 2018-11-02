package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OrderRepository;
import com.middleware.app.cow.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Order> find(Integer index, Integer totalCount,Order order) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return orderRepository.findAll(order);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Order get(Long id) throws CowException {
        try {
            return orderRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Order order) throws CowException {
        try {
            orderRepository.insert(order);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Order order) throws CowException {
        try {
            orderRepository.update(order);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            orderRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
