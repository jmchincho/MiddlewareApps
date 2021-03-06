package com.middleware.app.cow.service;

import java.util.List;
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

import static org.junit.Assert.assertEquals;
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
	private Address address;

	@Mock
	private List<Address> addresses;

	@Before
	public void setUp() throws Exception {
		when(addressRepository.findAll(any(), any(), any(), any())).thenReturn(addresses);

		when(addressRepository.count()).thenReturn(2L);

		when(addressRepository.findById(anyLong())).thenReturn(address);

		addressService = new AddressServiceImpl(addressRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAllAndReturnResult() throws CowException {
		List<Address> result = addressService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAllAndReturnException() throws Exception {
		when(addressRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		addressService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = addressService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(addressRepository.count()).thenThrow(new Exception());

		addressService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindByIdAndReturnResult() throws CowException {
		Address result = addressService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindByIdAndReturnException() throws Exception {
		when(addressRepository.findById(any())).thenThrow(new Exception());

		addressService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryInsertAndReturnResult() throws Exception {
		addressService.create(address);

		verify(addressRepository, times(1)).insert(address);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryInsertAndReturnException() throws Exception {
		doThrow(new Exception()).when(addressRepository).insert(any());

		addressService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryUpdateAndReturnResult() throws Exception {
		addressService.update(address);

		verify(addressRepository, times(1)).update(address);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryUpdateAndReturnException() throws Exception {
		doThrow(new Exception()).when(addressRepository).update(any());

		addressService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryDeleteAndReturnResult() throws Exception {
		addressService.delete(1L);

		verify(addressRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryDeleteAndReturnException() throws Exception {
		doThrow(new Exception()).when(addressRepository).delete(any());

		addressService.delete(any());
	}

}