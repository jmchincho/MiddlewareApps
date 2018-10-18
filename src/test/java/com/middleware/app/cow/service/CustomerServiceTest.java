package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

	private CustomerService CustomerService;

	@Mock
	private CustomerRepository CustomerRepository;

	@Mock
	private List<Customer> customers;

	@Mock
	private Customer customer;

	@Mock
	private Page<Customer> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(customers);

		when(CustomerRepository.findAll(any())).thenReturn(page);

		when(CustomerRepository.findById(anyLong())).thenReturn(customer);

		CustomerService = new CustomerServiceImpl(CustomerRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Customer> result = CustomerService.find(1,1, any(Customer.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CustomerRepository.findAll(any())).thenThrow(new Exception());

		CustomerService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Customer result = CustomerService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CustomerRepository.findAll(any())).thenThrow(new Exception());

		CustomerService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CustomerService.create(customer);

		verify(CustomerRepository, times(1)).insert(customer);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CustomerRepository).insert(any());

		CustomerService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CustomerService.update(customer);

		verify(CustomerRepository, times(1)).update(customer);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CustomerRepository).update(any());

		CustomerService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		CustomerService.delete(1L);

		verify(CustomerRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CustomerRepository).delete(any());

		CustomerService.delete(any());
	}

}