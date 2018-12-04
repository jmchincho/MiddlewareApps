package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {

    List<OrderDetail> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    OrderDetail get(Long id) throws CowException;

    void create(OrderDetail orderDetail) throws CowException;

    void update(OrderDetail orderDetail) throws CowException;

    void delete(Long id) throws CowException;

}
