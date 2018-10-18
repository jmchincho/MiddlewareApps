package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

	private SubcategoryService SubcategoryService;

	@Mock
	private SubcategoryRepository SubcategoryRepository;

	@Mock
	private List<Subcategory> subcategories;

	@Mock
	private Subcategory subcategory;

	@Mock
	private Page<Subcategory> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(subcategories);

		when(SubcategoryRepository.findAll(any())).thenReturn(page);

		when(SubcategoryRepository.findById(anyLong())).thenReturn(subcategory);

		SubcategoryService = new SubcategoryServiceImpl(SubcategoryRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Subcategory> result = SubcategoryService.find(1,1, any(Subcategory.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(SubcategoryRepository.findAll(any())).thenThrow(new Exception());

		SubcategoryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Subcategory result = SubcategoryService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(SubcategoryRepository.findAll(any())).thenThrow(new Exception());

		SubcategoryService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		SubcategoryService.create(subcategory);

		verify(SubcategoryRepository, times(1)).insert(subcategory);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(SubcategoryRepository).insert(any());

		SubcategoryService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		SubcategoryService.update(subcategory);

		verify(SubcategoryRepository, times(1)).update(subcategory);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(SubcategoryRepository).update(any());

		SubcategoryService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		SubcategoryService.delete(1L);

		verify(SubcategoryRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(SubcategoryRepository).delete(any());

		SubcategoryService.delete(any());
	}

}