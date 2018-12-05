package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OrderDetailRepository;
import com.middleware.app.cow.service.impl.OrderDetailServiceImpl;
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
public class OrderDetailServiceTest {

	private OrderDetailService orderDetailService;

	@Mock
	private OrderDetailRepository orderDetailRepository;

	@Mock
	private List<OrderDetail> orderDetails;

	@Mock
	private OrderDetail orderDetail;

	@Mock
	private List<OrderDetail> page;

	@Before
	public void setUp() throws Exception {
		when(orderDetailRepository.findAll(any(), any(), any(), any())).thenReturn(orderDetails);

		when(orderDetailRepository.count()).thenReturn(2L);

		when(orderDetailRepository.findById(anyLong())).thenReturn(orderDetail);

		orderDetailService = new OrderDetailServiceImpl(orderDetailRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<OrderDetail> result = orderDetailService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(orderDetailRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		orderDetailService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = orderDetailService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(orderDetailRepository.count()).thenThrow(new Exception());

		orderDetailService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		OrderDetail result = orderDetailService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(orderDetailRepository.findById(any())).thenThrow(new Exception());

		orderDetailService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		orderDetailService.create(orderDetail);

		verify(orderDetailRepository, times(1)).insert(orderDetail);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(orderDetailRepository).insert(any());

		orderDetailService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		orderDetailService.update(orderDetail);

		verify(orderDetailRepository, times(1)).update(orderDetail);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(orderDetailRepository).update(any());

		orderDetailService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		orderDetailService.delete(1L);

		verify(orderDetailRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(orderDetailRepository).delete(any());

		orderDetailService.delete(any());
	}

}