package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class OrderDetailServiceTest {

	private OrderDetailService OrderDetailService;

	@Mock
	private OrderDetailRepository OrderDetailRepository;

	@Mock
	private List<OrderDetail> orderDetails;

	@Mock
	private OrderDetail orderDetail;

	@Mock
	private Page<OrderDetail> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(orderDetails);

		when(OrderDetailRepository.findAll(any())).thenReturn(page);

		when(OrderDetailRepository.findById(anyLong())).thenReturn(orderDetail);

		OrderDetailService = new OrderDetailServiceImpl(OrderDetailRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<OrderDetail> result = OrderDetailService.find(1,1, any(OrderDetail.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(OrderDetailRepository.findAll(any())).thenThrow(new Exception());

		OrderDetailService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		OrderDetail result = OrderDetailService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(OrderDetailRepository.findAll(any())).thenThrow(new Exception());

		OrderDetailService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		OrderDetailService.create(orderDetail);

		verify(OrderDetailRepository, times(1)).insert(orderDetail);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OrderDetailRepository).insert(any());

		OrderDetailService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		OrderDetailService.update(orderDetail);

		verify(OrderDetailRepository, times(1)).update(orderDetail);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OrderDetailRepository).update(any());

		OrderDetailService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		OrderDetailService.delete(1L);

		verify(OrderDetailRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OrderDetailRepository).delete(any());

		OrderDetailService.delete(any());
	}

}