package com.middleware.app.cow.service;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CustomerRepository;
import com.middleware.app.cow.service.impl.CustomerServiceImpl;
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
public class CustomerServiceTest {

	private CustomerService customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private List<Customer> customers;

	@Mock
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		when(customerRepository.findAll(any(), any(), any(), any())).thenReturn(customers);

		when(customerRepository.findById(anyLong())).thenReturn(customer);

		customerService = new CustomerServiceImpl(customerRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Customer> result = customerService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(customerRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		customerService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Customer result = customerService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(customerRepository.findById(any())).thenThrow(new Exception());

		customerService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		customerService.create(customer);

		verify(customerRepository, times(1)).insert(customer);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(customerRepository).insert(any());

		customerService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		customerService.update(customer);

		verify(customerRepository, times(1)).update(customer);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(customerRepository).update(any());

		customerService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		customerService.delete(1L);

		verify(customerRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(customerRepository).delete(any());

		customerService.delete(any());
	}

}