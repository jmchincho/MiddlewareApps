package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class OfferServiceTest {

	private OfferService OfferService;

	@Mock
	private OfferRepository OfferRepository;

	@Mock
	private List<Offer> offers;

	@Mock
	private Offer offer;

	@Mock
	private Page<Offer> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(offers);

		when(OfferRepository.findAll(any())).thenReturn(page);

		when(OfferRepository.findById(anyLong())).thenReturn(offer);

		OfferService = new OfferServiceImpl(OfferRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Offer> result = OfferService.find(1,1, any(Offer.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(OfferRepository.findAll(any())).thenThrow(new Exception());

		OfferService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Offer result = OfferService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(OfferRepository.findAll(any())).thenThrow(new Exception());

		OfferService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		OfferService.create(offer);

		verify(OfferRepository, times(1)).insert(offer);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OfferRepository).insert(any());

		OfferService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		OfferService.update(offer);

		verify(OfferRepository, times(1)).update(offer);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OfferRepository).update(any());

		OfferService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		OfferService.delete(1L);

		verify(OfferRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(OfferRepository).delete(any());

		OfferService.delete(any());
	}

}