package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Override
    public Page<OrderDetail> find(Integer index, Integer totalCount,OrderDetail orderDetail) throws CowException {
        return null;
    }

    @Override
    public OrderDetail get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(OrderDetail orderDetail) throws CowException {

    }

    @Override
    public void update(OrderDetail orderDetail) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
