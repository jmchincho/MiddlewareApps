package com.middleware.app.cow.service;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.SubcriptionRepository;
import com.middleware.app.cow.service.impl.SubcriptionServiceImpl;
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
public class SubcriptionServiceTest {

	private SubcriptionService subcriptionService;

	@Mock
	private SubcriptionRepository subcriptionRepository;

	@Mock
	private List<Subcription> subcriptions;

	@Mock
	private Subcription subcription;

	@Before
	public void setUp() throws Exception {
		when(subcriptionRepository.findAll(any(), any(), any(), any())).thenReturn(subcriptions);

		when(subcriptionRepository.count()).thenReturn(2L);

		when(subcriptionRepository.findById(anyLong())).thenReturn(subcription);

		subcriptionService = new SubcriptionServiceImpl(subcriptionRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Subcription> result = subcriptionService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(subcriptionRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		subcriptionService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = subcriptionService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(subcriptionRepository.count()).thenThrow(new Exception());

		subcriptionService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Subcription result = subcriptionService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(subcriptionRepository.findById(any())).thenThrow(new Exception());

		subcriptionService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		subcriptionService.create(subcription);

		verify(subcriptionRepository, times(1)).insert(subcription);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(subcriptionRepository).insert(any());

		subcriptionService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		subcriptionService.update(subcription);

		verify(subcriptionRepository, times(1)).update(subcription);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(subcriptionRepository).update(any());

		subcriptionService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		subcriptionService.delete(1L);

		verify(subcriptionRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(subcriptionRepository).delete(any());

		subcriptionService.delete(any());
	}

}