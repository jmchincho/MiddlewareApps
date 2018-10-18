package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {

    Page<OrderDetail> find(Integer index, Integer totalCount,OrderDetail orderDetail) throws CowException;

    OrderDetail get(Long id) throws CowException;

    void create(OrderDetail orderDetail) throws CowException;

    void update(OrderDetail orderDetail) throws CowException;

    void delete(Long id) throws CowException;

}
