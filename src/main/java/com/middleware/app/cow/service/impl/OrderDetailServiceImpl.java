package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OrderDetailRepository;
import com.middleware.app.cow.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Page<OrderDetail> find(Integer index, Integer totalCount,OrderDetail orderDetail) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return orderDetailRepository.findAll(orderDetail);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public OrderDetail get(Long id) throws CowException {
        try {
            return orderDetailRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(OrderDetail orderDetail) throws CowException {
        try {
            orderDetailRepository.insert(orderDetail);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(OrderDetail orderDetail) throws CowException {
        try {
            orderDetailRepository.update(orderDetail);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            orderDetailRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
