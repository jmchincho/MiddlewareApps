package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.BannerAdsRepository;
import com.middleware.app.cow.service.impl.BannerAdsServiceImpl;
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
public class BannerAdsServiceTest {

	private BannerAdsService bannerAdsService;

	@Mock
	private BannerAdsRepository bannerAdsRepository;

	@Mock
	private List<BannerAds> bannersAds;

	@Mock
	private BannerAds bannerAds;

	@Before
	public void setUp() throws Exception {
		when(bannerAdsRepository.findAll(any(), any(), any(), any())).thenReturn(bannersAds);

		when(bannerAdsRepository.count()).thenReturn(2L);

		when(bannerAdsRepository.findById(anyLong())).thenReturn(bannerAds);

		bannerAdsService = new BannerAdsServiceImpl(bannerAdsRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<BannerAds> result = bannerAdsService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(bannerAdsRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		bannerAdsService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void countAllShouldCallRepositoryCountAndReturnResult() throws CowException {
		Long result = bannerAdsService.countAll();

		assertNotNull(result);
		assertEquals(result, Long.valueOf(2L));
	}

	@Test(expected = CowException.class)
	public void countAllShouldCallRepositoryCountAndReturnException() throws Exception {
		when(bannerAdsRepository.count()).thenThrow(new Exception());

		bannerAdsService.countAll();
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		BannerAds result = bannerAdsService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(bannerAdsRepository.findById(any())).thenThrow(new Exception());

		bannerAdsService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		bannerAdsService.create(bannerAds);

		verify(bannerAdsRepository, times(1)).insert(bannerAds);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(bannerAdsRepository).insert(any());

		bannerAdsService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		bannerAdsService.update(bannerAds);

		verify(bannerAdsRepository, times(1)).update(bannerAds);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(bannerAdsRepository).update(any());

		bannerAdsService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		bannerAdsService.delete(1L);

		verify(bannerAdsRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new Exception()).when(bannerAdsRepository).delete(any());

		bannerAdsService.delete(any());
	}

}