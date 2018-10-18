package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.ProvinceRepository;
import com.middleware.app.cow.service.impl.ProvinceServiceImpl;
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
public class ProvinceServiceTest {

	private ProvinceService ProvinceService;

	@Mock
	private ProvinceRepository ProvinceRepository;

	@Mock
	private List<Province> provinces;

	@Mock
	private Province province;

	@Mock
	private Page<Province> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(provinces);

		when(ProvinceRepository.findAll(any())).thenReturn(page);

		when(ProvinceRepository.findById(anyLong())).thenReturn(province);

		ProvinceService = new ProvinceServiceImpl(ProvinceRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Province> result = ProvinceService.find(1,1, any(Province.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(ProvinceRepository.findAll(any())).thenThrow(new Exception());

		ProvinceService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Province result = ProvinceService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(ProvinceRepository.findAll(any())).thenThrow(new Exception());

		ProvinceService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		ProvinceService.create(province);

		verify(ProvinceRepository, times(1)).insert(province);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(ProvinceRepository).insert(any());

		ProvinceService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		ProvinceService.update(province);

		verify(ProvinceRepository, times(1)).update(province);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(ProvinceRepository).update(any());

		ProvinceService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		ProvinceService.delete(1L);

		verify(ProvinceRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(ProvinceRepository).delete(any());

		ProvinceService.delete(any());
	}

}