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

	private CategoryService CategoryService;

	@Mock
	private CategoryRepository CategoryRepository;

	@Mock
	private List<Category> categories;

	@Mock
	private Category category;

	@Mock
	private Page<Category> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(categories);

		when(CategoryRepository.findAll(any())).thenReturn(page);

		when(CategoryRepository.findById(anyLong())).thenReturn(category);

		CategoryService = new CategoryServiceImpl(CategoryRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Category> result = CategoryService.find(1,1, any(Category.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CategoryRepository.findAll(any())).thenThrow(new Exception());

		CategoryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Category result = CategoryService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CategoryRepository.findAll(any())).thenThrow(new Exception());

		CategoryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CategoryService.create(category);

		verify(CategoryRepository, times(1)).insert(category);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CategoryRepository).insert(any());

		CategoryService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CategoryService.update(category);

		verify(CategoryRepository, times(1)).update(category);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CategoryRepository).update(any());

		CategoryService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		CategoryService.delete(1L);

		verify(CategoryRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CategoryRepository).delete(any());

		CategoryService.delete(any());
	}

}