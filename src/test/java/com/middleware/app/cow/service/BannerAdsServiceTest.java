package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class BannerAdsServiceTest {

	private BannerAdsService BannerAdsService;

	@Mock
	private BannerAdsRepository BannerAdsRepository;

	@Mock
	private List<BannerAds> bannersAds;

	@Mock
	private BannerAds bannerAds;

	@Mock
	private Page<BannerAds> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(bannersAds);

		when(BannerAdsRepository.findAll(any())).thenReturn(page);

		when(BannerAdsRepository.findById(anyLong())).thenReturn(bannerAds);

		BannerAdsService = new BannerAdsServiceImpl(BannerAdsRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<BannerAds> result = BannerAdsService.find(1,1, any(BannerAds.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(BannerAdsRepository.findAll(any())).thenThrow(new Exception());

		BannerAdsService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		BannerAds result = BannerAdsService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(BannerAdsRepository.findAll(any())).thenThrow(new Exception());

		BannerAdsService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		BannerAdsService.create(bannerAds);

		verify(BannerAdsRepository, times(1)).insert(bannerAds);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(BannerAdsRepository).insert(any());

		BannerAdsService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		BannerAdsService.update(bannerAds);

		verify(BannerAdsRepository, times(1)).update(bannerAds);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(BannerAdsRepository).update(any());

		BannerAdsService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		BannerAdsService.delete(1L);

		verify(BannerAdsRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(BannerAdsRepository).delete(any());

		BannerAdsService.delete(any());
	}

}