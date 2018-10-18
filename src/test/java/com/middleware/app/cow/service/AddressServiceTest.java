package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.AddressRepository;
import com.middleware.app.cow.service.impl.AddressServiceImpl;
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
public class AddressServiceTest {

	private AddressService addressService;

	@Mock
	private AddressRepository addressRepository;

	@Mock
	private List<Address> addresses;

	@Mock
	private Address address;

	@Mock
	private Page<Address> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(addresses);

		when(addressRepository.findAll(any())).thenReturn(page);

		when(addressRepository.findById(anyLong())).thenReturn(address);

		addressService = new AddressServiceImpl(addressRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Address> result = addressService.find(1,1, any(Address.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(addressRepository.findAll(any())).thenThrow(new Exception());

		addressService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Address result = addressService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(addressRepository.findAll(any())).thenThrow(new Exception());

		addressService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		addressService.create(address);

		verify(addressRepository, times(1)).insert(address);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(addressRepository).insert(any());

		addressService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		addressService.update(address);

		verify(addressRepository, times(1)).update(address);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(addressRepository).update(any());

		addressService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		addressService.delete(1L);

		verify(addressRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(addressRepository).delete(any());

		addressService.delete(any());
	}

}