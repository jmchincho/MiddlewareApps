package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CountryRepository;
import com.middleware.app.cow.service.impl.CountryServiceImpl;
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
public class CountryServiceTest {

	private CountryService CountryService;

	@Mock
	private CountryRepository CountryRepository;

	@Mock
	private List<Country> countries;

	@Mock
	private Country country;

	@Mock
	private Page<Country> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(countries);

		when(CountryRepository.findAll(any())).thenReturn(page);

		when(CountryRepository.findById(anyLong())).thenReturn(country);

		CountryService = new CountryServiceImpl(CountryRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Country> result = CountryService.find(1,1, any(Country.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CountryRepository.findAll(any())).thenThrow(new Exception());

		CountryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Country result = CountryService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CountryRepository.findAll(any())).thenThrow(new Exception());

		CountryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CountryService.create(country);

		verify(CountryRepository, times(1)).insert(country);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CountryRepository).insert(any());

		CountryService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CountryService.update(country);

		verify(CountryRepository, times(1)).update(country);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CountryRepository).update(any());

		CountryService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		CountryService.delete(1L);

		verify(CountryRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CountryRepository).delete(any());

		CountryService.delete(any());
	}

}