package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderRepositoryTestIT {

    @Autowired
    public OrderRepository orderRepository;

    @Mock
    private Order order;

    @Mock
    private Address address;

    @Before
    public void setUp() throws Exception {
        when(address.getId()).thenReturn(1L);

        when(order.getAddress()).thenReturn(address);
    }

    @Test
    public void findShouldReturnAllOrderByUser() throws Exception {
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Order.class.getSimpleName());

        List<Order> result = orderRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        //assertTrue(result.stream().anyMatch(order -> order.getAddress().getId().equals(address.getId())));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = orderRepository.count();

        assertNotNull(result);
    }

    @Test
    public void getShouldReturnOrderById1() throws Exception {
        Order result = orderRepository.findById(2L);

        assertNotNull(result);
        assertTrue(result.getObservations().equals("observations2"));
        assertTrue(result.getAddress().getId().equals(address.getId()));
        assertTrue(result.getId().equals(2L));
    }

    @Test
    public void createAllShouldInsertNewOrder() throws Exception {
        when(order.getObservations()).thenReturn("observations3");
        when(order.getPaidOrder()).thenReturn("paidOrder");
        when(order.getPaymentType()).thenReturn("paymentType");
        when(order.getPriceTotal()).thenReturn(3000.00);
        when(order.getState()).thenReturn("enabled");

        orderRepository.insert(order);

        Order result = orderRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getObservations().equals("observations3"));
        assertTrue(result.getAddress().getId().equals(address.getId()));
        assertTrue(result.getId().equals(3L));
    }

    @Test
    public void updateAllShouldUpdateOrderById() throws Exception {
        Order update = orderRepository.findById(3L);
        update.setObservations("observations4");
        update.setPriceTotal(3500.00);

        orderRepository.update(update);

        Order result = orderRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getObservations().equals("observations4"));
        assertTrue(result.getPriceTotal().equals(3500.00));
        assertTrue(result.getId().equals(3L));
    }

    @Test
    public void deleteShouldRemoveOrderById() throws Exception {
        orderRepository.delete(1L);

        Order orderDelete = orderRepository.findById(1L);

        assertTrue(orderDelete.isDeleted());
    }
}