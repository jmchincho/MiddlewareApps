package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.LocationRepository;
import com.middleware.app.cow.service.impl.LocationServiceImpl;
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
public class LocationServiceTest {

	private LocationService LocationService;

	@Mock
	private LocationRepository LocationRepository;

	@Mock
	private List<Location> locations;

	@Mock
	private Location location;

	@Mock
	private Page<Location> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(locations);

		when(LocationRepository.findAll(any())).thenReturn(page);

		when(LocationRepository.findById(anyLong())).thenReturn(location);

		LocationService = new LocationServiceImpl(LocationRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Location> result = LocationService.find(1,1, any(Location.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(LocationRepository.findAll(any())).thenThrow(new Exception());

		LocationService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Location result = LocationService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(LocationRepository.findAll(any())).thenThrow(new Exception());

		LocationService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		LocationService.create(location);

		verify(LocationRepository, times(1)).insert(location);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(LocationRepository).insert(any());

		LocationService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		LocationService.update(location);

		verify(LocationRepository, times(1)).update(location);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(LocationRepository).update(any());

		LocationService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		LocationService.delete(1L);

		verify(LocationRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(LocationRepository).delete(any());

		LocationService.delete(any());
	}

}