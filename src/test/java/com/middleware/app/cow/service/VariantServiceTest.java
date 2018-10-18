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

	private VariantService VariantService;

	@Mock
	private VariantRepository VariantRepository;

	@Mock
	private List<Variant> variants;

	@Mock
	private Variant variant;

	@Mock
	private Page<Variant> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(variants);

		when(VariantRepository.findAll(any())).thenReturn(page);

		when(VariantRepository.findById(anyLong())).thenReturn(variant);

		VariantService = new VariantServiceImpl(VariantRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Variant> result = VariantService.find(1,1, any(Variant.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(VariantRepository.findAll(any())).thenThrow(new Exception());

		VariantService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Variant result = VariantService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(VariantRepository.findAll(any())).thenThrow(new Exception());

		VariantService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		VariantService.create(variant);

		verify(VariantRepository, times(1)).insert(variant);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(VariantRepository).insert(any());

		VariantService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		VariantService.update(variant);

		verify(VariantRepository, times(1)).update(variant);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(VariantRepository).update(any());

		VariantService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		VariantService.delete(1L);

		verify(VariantRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(VariantRepository).delete(any());

		VariantService.delete(any());
	}

}