package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.domain.OrderDetail;
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
public class OrderDetailRepositoryTestIT {

    @Autowired
    public OrderDetailRepository orderDetailRepository;

    @Mock
    private OrderDetail orderDetail;

    @Mock
    private Item item;

    @Mock
    private Order order;

    @Before
    public void setUp() throws Exception {
        when(item.getId()).thenReturn(1L);

        when(order.getId()).thenReturn(1L);
    }

    @Test
    public void findShouldReturnAllOrderDetailByUser() throws Exception {
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(OrderDetail.class.getSimpleName());

        List<OrderDetail> result = orderDetailRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(orderDetail -> orderDetail.getPrice().equals(130.0)));
        assertTrue(result.stream().anyMatch(orderDetail -> orderDetail.getItem().getId().equals(item.getId())));
    }

    @Test
    public void getShouldReturnOrderDetailById1() throws Exception {
        OrderDetail result = orderDetailRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(500.00));
        assertTrue(result.getItem().getId().equals(item.getId()));
        assertTrue(result.getQuantity().equals(3));
        assertTrue(result.getOrder().getId().equals(order.getId()));
    }

    @Test
    public void createAllShouldInsertNewOrderDetail() throws Exception {
        when(orderDetail.getItem()).thenReturn(item);
        when(orderDetail.getOrder()).thenReturn(order);
        when(orderDetail.getPrice()).thenReturn(29.99);
        when(orderDetail.getQuantity()).thenReturn(5);
        when(orderDetail.getSendState()).thenReturn("sendState");

        orderDetailRepository.insert(orderDetail);

        OrderDetail result = orderDetailRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(29.99));
        assertTrue(result.getItem().getId().equals(item.getId()));
        assertTrue(result.getQuantity().equals(5));
        assertTrue(result.getOrder().getId().equals(order.getId()));
    }

    @Test
    public void updateAllShouldUpdateOrderDetailById() throws Exception {
        OrderDetail update = orderDetailRepository.findById(3L);
        update.setQuantity(4);

        orderDetailRepository.update(update);

        OrderDetail result = orderDetailRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(29.99));
        assertTrue(result.getItem().getId().equals(item.getId()));
        assertTrue(result.getQuantity().equals(4));
        assertTrue(result.getOrder().getId().equals(order.getId()));
    }

    @Test
    public void deleteShouldRemoveOrderDetailById() throws Exception {
        orderDetailRepository.delete(3L);

        OrderDetail orderDetailDelete = orderDetailRepository.findById(3L);

        assertTrue(orderDetailDelete.isDeleted());
    }
}