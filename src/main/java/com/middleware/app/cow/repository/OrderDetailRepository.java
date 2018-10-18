package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailRepository {

    Page<OrderDetail> findAll(OrderDetail orderDetail) throws Exception;

    OrderDetail findById(Long id) throws Exception;

    void insert(OrderDetail orderDetail) throws Exception;

    void update(OrderDetail orderDetail) throws Exception;

    void delete(Long id) throws Exception;

}