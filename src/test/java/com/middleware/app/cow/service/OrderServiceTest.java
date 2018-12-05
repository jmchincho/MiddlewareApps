package com.middleware.app.cow.service;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OrderRepository;
import com.middleware.app.cow.service.impl.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class OrderServiceTest {

	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private List<Order> orders;

	@Mock
	private Order order;

	@Mock
	private List<Order> page;

	@Before
	public void setUp() throws Exception {
		when(orderRepository.findAll(any(), any(), any(), any())).thenReturn(orders);

		when(orderRepository.count()).thenReturn(2L);

		when(orderRepository.findById(anyLong())).thenReturn(order);

		orderService = new OrderServiceImpl(orderRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Order> result = orderService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(orderRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		orderService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = orderService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(orderRepository.count()).thenThrow(new Exception());

		orderService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Order result = orderService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(orderRepository.findById(any())).thenThrow(new Exception());

		orderService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		orderService.create(order);

		verify(orderRepository, times(1)).insert(order);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(orderRepository).insert(any());

		orderService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		orderService.update(order);

		verify(orderRepository, times(1)).update(order);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(orderRepository).update(any());

		orderService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		orderService.delete(1L);

		verify(orderRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(orderRepository).delete(any());

		orderService.delete(any());
	}

}