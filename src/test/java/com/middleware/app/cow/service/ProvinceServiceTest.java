package com.middleware.app.cow.service;

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

	private ProvinceService provinceService;

	@Mock
	private ProvinceRepository provinceRepository;

	@Mock
	private List<Province> provinces;

	@Mock
	private Province province;

	@Before
	public void setUp() throws Exception {
		when(provinceRepository.findAll(any(), any(), any(), any())).thenReturn(provinces);

		when(provinceRepository.findById(anyLong())).thenReturn(province);

		provinceService = new ProvinceServiceImpl(provinceRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Province> result = provinceService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(provinceRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		provinceService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Province result = provinceService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(provinceRepository.findById(any())).thenThrow(new Exception());

		provinceService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		provinceService.create(province);

		verify(provinceRepository, times(1)).insert(province);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(provinceRepository).insert(any());

		provinceService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		provinceService.update(province);

		verify(provinceRepository, times(1)).update(province);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(provinceRepository).update(any());

		provinceService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		provinceService.delete(1L);

		verify(provinceRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(provinceRepository).delete(any());

		provinceService.delete(any());
	}

}