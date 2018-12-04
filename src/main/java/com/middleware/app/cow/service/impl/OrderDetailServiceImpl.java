package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OrderDetailRepository;
import com.middleware.app.cow.service.OrderDetailService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(OrderDetail.class.getSimpleName());

            return orderDetailRepository.findAll(table, where, orderBy, rowBounds);
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
