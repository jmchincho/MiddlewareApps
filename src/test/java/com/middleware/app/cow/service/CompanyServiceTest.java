package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CompanyRepository;
import com.middleware.app.cow.service.impl.CompanyServiceImpl;
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
public class CompanyServiceTest {

	private CompanyService companyService;

	@Mock
	private CompanyRepository companyRepository;

	@Mock
	private List<Company> companies;

	@Mock
	private Company company;

	@Before
	public void setUp() throws Exception {
		when(companyRepository.findAll(any(), any(), any(), any())).thenReturn(companies);

		when(companyRepository.findById(anyLong())).thenReturn(company);

		companyService = new CompanyServiceImpl(companyRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Company> result = companyService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(companyRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		companyService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Company result = companyService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(companyRepository.findById(any())).thenThrow(new Exception());

		companyService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		companyService.create(company);

		verify(companyRepository, times(1)).insert(company);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(companyRepository).insert(any());

		companyService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		companyService.update(company);

		verify(companyRepository, times(1)).update(company);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(companyRepository).update(any());

		companyService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		companyService.delete(1L);

		verify(companyRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(companyRepository).delete(any());

		companyService.delete(any());
	}

}