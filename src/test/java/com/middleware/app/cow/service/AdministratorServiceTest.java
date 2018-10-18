package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

	private AdministratorService AdministratorService;

	@Mock
	private AdministratorRepository AdministratorRepository;

	@Mock
	private List<Administrator> adminstrators;

	@Mock
	private Administrator administrator;

	@Mock
	private Page<Administrator> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(adminstrators);

		when(AdministratorRepository.findAll(any())).thenReturn(page);

		when(AdministratorRepository.findById(anyLong())).thenReturn(administrator);

		AdministratorService = new AdministratorServiceImpl(AdministratorRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Administrator> result = AdministratorService.find(1,1, any(Administrator.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(AdministratorRepository.findAll(any())).thenThrow(new Exception());

		AdministratorService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Administrator result = AdministratorService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(AdministratorRepository.findAll(any())).thenThrow(new Exception());

		AdministratorService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		AdministratorService.create(administrator);

		verify(AdministratorRepository, times(1)).insert(administrator);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(AdministratorRepository).insert(any());

		AdministratorService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		AdministratorService.update(administrator);

		verify(AdministratorRepository, times(1)).update(administrator);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(AdministratorRepository).update(any());

		AdministratorService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		AdministratorService.delete(1L);

		verify(AdministratorRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(AdministratorRepository).delete(any());

		AdministratorService.delete(any());
	}

}º