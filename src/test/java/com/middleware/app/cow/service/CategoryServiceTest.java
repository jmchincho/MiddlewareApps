package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CategoryRepository;
import com.middleware.app.cow.service.impl.CategoryServiceImpl;
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
public class CategoryServiceTest {

	private CategoryService categoryService;

	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private List<Category> categories;

	@Mock
	private Category category;

	@Before
	public void setUp() throws Exception {
		when(categoryRepository.findAll(any(), any(), any(), any())).thenReturn(categories);

		when(categoryRepository.count()).thenReturn(2L);

		when(categoryRepository.findById(anyLong())).thenReturn(category);

		categoryService = new CategoryServiceImpl(categoryRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Category> result = categoryService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(categoryRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		categoryService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = categoryService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(categoryRepository.count()).thenThrow(new Exception());

		categoryService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Category result = categoryService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(categoryRepository.findById(any())).thenThrow(new Exception());

		categoryService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		categoryService.create(category);

		verify(categoryRepository, times(1)).insert(category);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(categoryRepository).insert(any());

		categoryService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		categoryService.update(category);

		verify(categoryRepository, times(1)).update(category);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(categoryRepository).update(any());

		categoryService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		categoryService.delete(1L);

		verify(categoryRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(categoryRepository).delete(any());

		categoryService.delete(any());
	}

}