package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.VariantRepository;
import com.middleware.app.cow.service.impl.VariantServiceImpl;
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
public class VariantServiceTest {

	private VariantService variantService;

	@Mock
	private VariantRepository variantRepository;

	@Mock
	private List<Variant> variants;

	@Mock
	private Variant variant;

	@Mock
	private Page<Variant> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(variants);

		when(variantRepository.findAll(any())).thenReturn(page);

		when(variantRepository.findById(anyLong())).thenReturn(variant);

		variantService = new VariantServiceImpl(variantRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Variant> result = variantService.find(1,1, any(Variant.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(variantRepository.findAll(any())).thenThrow(new Exception());

		variantService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Variant result = variantService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(variantRepository.findAll(any())).thenThrow(new Exception());

		variantService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		variantService.create(variant);

		verify(variantRepository, times(1)).insert(variant);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(variantRepository).insert(any());

		variantService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		variantService.update(variant);

		verify(variantRepository, times(1)).update(variant);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(variantRepository).update(any());

		variantService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		variantService.delete(1L);

		verify(variantRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(variantRepository).delete(any());

		variantService.delete(any());
	}

}