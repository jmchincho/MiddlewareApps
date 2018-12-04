package com.middleware.app.cow.service;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.AdministratorRepository;
import com.middleware.app.cow.service.impl.AdministratorServiceImpl;
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
public class AdministratorServiceTest {

	private AdministratorService administratorService;

	@Mock
	private AdministratorRepository administratorRepository;

	@Mock
	private List<Administrator> administrators;

	@Mock
	private Administrator administrator;

	@Before
	public void setUp() throws Exception {
		when(administratorRepository.findAll(any(), any(), any(), any())).thenReturn(administrators);

		when(administratorRepository.findById(anyLong())).thenReturn(administrator);

		administratorService = new AdministratorServiceImpl(administratorRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Administrator> result = administratorService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(administratorRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		administratorService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Administrator result = administratorService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(administratorRepository.findById(any())).thenThrow(new Exception());

		administratorService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		administratorService.create(administrator);

		verify(administratorRepository, times(1)).insert(administrator);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(administratorRepository).insert(any());

		administratorService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		administratorService.update(administrator);

		verify(administratorRepository, times(1)).update(administrator);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(administratorRepository).update(any());

		administratorService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		administratorService.delete(1L);

		verify(administratorRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(administratorRepository).delete(any());

		administratorService.delete(any());
	}

}