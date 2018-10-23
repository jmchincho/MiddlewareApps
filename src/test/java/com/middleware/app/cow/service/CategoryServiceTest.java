package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

	@Mock
	private Page<Category> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(categories);

		when(categoryRepository.findAll(any())).thenReturn(page);

		when(categoryRepository.findById(anyLong())).thenReturn(category);

		categoryService = new CategoryServiceImpl(categoryRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Category> result = categoryService.find(1,1, any(Category.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(categoryRepository.findAll(any())).thenThrow(new Exception());

		categoryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Category result = categoryService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(categoryRepository.findAll(any())).thenThrow(new Exception());

		categoryService.find(anyInt(), anyInt(), any());
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