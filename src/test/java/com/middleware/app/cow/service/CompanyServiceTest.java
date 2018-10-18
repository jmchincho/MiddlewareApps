package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

	private CompanyService CompanyService;

	@Mock
	private CompanyRepository CompanyRepository;

	@Mock
	private List<Company> companies;

	@Mock
	private Company company;

	@Mock
	private Page<Company> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(companies);

		when(CompanyRepository.findAll(any())).thenReturn(page);

		when(CompanyRepository.findById(anyLong())).thenReturn(company);

		CompanyService = new CompanyServiceImpl(CompanyRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Company> result = CompanyService.find(1,1, any(Company.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CompanyRepository.findAll(any())).thenThrow(new Exception());

		CompanyService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Company result = CompanyService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CompanyRepository.findAll(any())).thenThrow(new Exception());

		CompanyService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CompanyService.create(company);

		verify(CompanyRepository, times(1)).insert(company);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CompanyRepository).insert(any());

		CompanyService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CompanyService.update(company);

		verify(CompanyRepository, times(1)).update(company);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CompanyRepository).update(any());

		CompanyService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		CompanyService.delete(1L);

		verify(CompanyRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CompanyRepository).delete(any());

		CompanyService.delete(any());
	}

}