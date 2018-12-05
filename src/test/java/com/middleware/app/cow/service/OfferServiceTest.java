package com.middleware.app.cow.service;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.OfferRepository;
import com.middleware.app.cow.service.impl.OfferServiceImpl;
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
public class OfferServiceTest {

	private OfferService offerService;

	@Mock
	private OfferRepository offerRepository;

	@Mock
	private List<Offer> offers;

	@Mock
	private Offer offer;

	@Before
	public void setUp() throws Exception {
		when(offerRepository.findAll(any(), any(), any(), any())).thenReturn(offers);

		when(offerRepository.count()).thenReturn(2L);

		when(offerRepository.findById(anyLong())).thenReturn(offer);

		offerService = new OfferServiceImpl(offerRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Offer> result = offerService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(offerRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		offerService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = offerService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(offerRepository.count()).thenThrow(new Exception());

		offerService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Offer result = offerService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(offerRepository.findById(any())).thenThrow(new Exception());

		offerService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		offerService.create(offer);

		verify(offerRepository, times(1)).insert(offer);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(offerRepository).insert(any());

		offerService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		offerService.update(offer);

		verify(offerRepository, times(1)).update(offer);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(offerRepository).update(any());

		offerService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		offerService.delete(1L);

		verify(offerRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(offerRepository).delete(any());

		offerService.delete(any());
	}

}