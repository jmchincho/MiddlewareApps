package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class OrderServiceTest {

	private OrderService OrderService;

	@Mock
	private OrderRepository OrderRepository;

	@Mock
	private List<Order> orders;

	@Mock
	private Order order;

	@Mock
	private Page<Order> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(orders);

		when(OrderRepository.findAll(any())).thenReturn(page);

		when(OrderRepository.findById(anyLong())).thenReturn(order);

		OrderService = new OrderServiceImpl(OrderRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Order> result = OrderService.find(1,1, any(Order.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(OrderRepository.findAll(any())).thenThrow(new Exception());

		OrderService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Order result = OrderService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(OrderRepository.findAll(any())).thenThrow(new Exception());

		OrderService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		OrderService.create(order);

		verify(OrderRepository, times(1)).insert(order);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OrderRepository).insert(any());

		OrderService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		OrderService.update(order);

		verify(OrderRepository, times(1)).update(order);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OrderRepository).update(any());

		OrderService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		OrderService.delete(1L);

		verify(OrderRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OrderRepository).delete(any());

		OrderService.delete(any());
	}

}