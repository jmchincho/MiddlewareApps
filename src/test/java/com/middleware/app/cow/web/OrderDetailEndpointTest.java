package com.middleware.app.cow.web;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OrderDetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class OrderDetailEndpointTest {

    @Mock
    private OrderDetailService orderDetailService;

    private OrderDetailEndpoint orderDetailEndpoint;

    @Mock
    private List<OrderDetail> orderDetails;

    @Mock
    private OrderDetail orderDetail;

    @Before
    public void setUp() throws Exception {
        when(orderDetailService.find(anyInt(), anyInt(), anyString(), anyString())).thenReturn(orderDetails);

        when(orderDetailService.countAll()).thenReturn(2L);

        when(orderDetailService.get(any())).thenReturn(orderDetail);

        orderDetailEndpoint = new OrderDetailEndpoint(orderDetailService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = orderDetailEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(orderDetailService.find(anyInt(), anyInt(), anyString(), anyString())).thenThrow(new CowException());

        Response result = orderDetailEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnResult() {
        Response result = orderDetailEndpoint.countAll();

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnException() throws CowException {
        when(orderDetailService.countAll()).thenThrow(new CowException());

        Response result = orderDetailEndpoint.countAll();
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = orderDetailEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(orderDetailService.get(any())).thenThrow(new CowException());

        Response result = orderDetailEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = orderDetailEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(orderDetailService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(orderDetailService).create(any());

        Response result = orderDetailEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = orderDetailEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(orderDetailService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(orderDetailService).update(any());

        Response result = orderDetailEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = orderDetailEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(orderDetailService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(orderDetailService).delete(any());

        Response result = orderDetailEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}