package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.SubcategoryRepository;
import com.middleware.app.cow.service.impl.SubcategoryServiceImpl;
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
public class SubcategoryServiceTest {

	private SubcategoryService subcategoryService;

	@Mock
	private SubcategoryRepository subcategoryRepository;

	@Mock
	private List<Subcategory> subcategories;

	@Mock
	private Subcategory subcategory;

	@Before
	public void setUp() throws Exception {
		when(subcategoryRepository.findAll(any(), any(), any(), any())).thenReturn(subcategories);

		when(subcategoryRepository.findById(anyLong())).thenReturn(subcategory);

		subcategoryService = new SubcategoryServiceImpl(subcategoryRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Subcategory> result = subcategoryService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(subcategoryRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		subcategoryService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Subcategory result = subcategoryService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(subcategoryRepository.findById(any())).thenThrow(new Exception());

		subcategoryService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		subcategoryService.create(subcategory);

		verify(subcategoryRepository, times(1)).insert(subcategory);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(subcategoryRepository).insert(any());

		subcategoryService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		subcategoryService.update(subcategory);

		verify(subcategoryRepository, times(1)).update(subcategory);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(subcategoryRepository).update(any());

		subcategoryService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		subcategoryService.delete(1L);

		verify(subcategoryRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(subcategoryRepository).delete(any());

		subcategoryService.delete(any());
	}

}