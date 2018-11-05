package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.BannerAds;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BannerAdsRepositoryTestIT {

    @Autowired
    public BannerAdsRepository bannerAdsRepository;

    @Mock
    private BannerAds bannerAds;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllBannerAds() throws Exception {
        Page<BannerAds> result = bannerAdsRepository.findAll(null);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(bannerAds -> bannerAds.getTitle().equals("title1")));
    }

    @Test
    public void findShouldReturnBannerAdsByFilterBannerAds() throws Exception {
        when(bannerAds.getTitle()).thenReturn("title1");

        Page<BannerAds> result = bannerAdsRepository.findAll(bannerAds);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(bannerAds -> bannerAds.getTitle().equals("title1")));
    }

    @Test
    public void getShouldReturnBannerAdsById1() throws Exception {
        BannerAds result = bannerAdsRepository.findById(2L);

        assertNotNull(result);
        assertThat(result.getTitle(), equalTo("title2"));
    }

    @Test
    public void createAllShouldInsertNewBannerAds() throws Exception {
        when(bannerAds.getTitle()).thenReturn("titulo1");
        when(bannerAds.getCreateDate()).thenReturn(new Date());
        when(bannerAds.getDescription()).thenReturn("description1");
        when(bannerAds.getFinishDate()).thenReturn(new Date());
        when(bannerAds.getImage()).thenReturn("image1");
        when(bannerAds.getSequence()).thenReturn(1);
        when(bannerAds.getStartDate()).thenReturn(new Date());
        when(bannerAds.getUrl()).thenReturn("url");
        when(bannerAds.getState()).thenReturn("enabled");

        bannerAdsRepository.insert(bannerAds);

        BannerAds result = bannerAdsRepository.findById(3L);

        assertNotNull(result);
        assertThat(result.getTitle(), equalTo("titulo1"));
        assertThat(result.getDescription(), equalTo("description1"));
        assertThat(result.getImage(), equalTo("image1"));
        assertThat(result.getSequence(), equalTo(1));
    }

    @Test
    public void updateAllShouldUpdateBannerAdsById() throws Exception {
        BannerAds update = bannerAdsRepository.findById(3L);
        update.setTitle("titulo1Mod");

        bannerAdsRepository.update(update);

        BannerAds result = bannerAdsRepository.findById(3L);

        assertNotNull(result);
        assertThat(result.getTitle(), equalTo("titulo1Mod"));
        assertThat(result.getDescription(), equalTo("description1"));
        assertThat(result.getImage(), equalTo("image1"));
        assertThat(result.getSequence(), equalTo(1));
    }

    @Test
    public void deleteShouldRemoveBannerAdsById() throws Exception {
        bannerAdsRepository.delete(2L);

        BannerAds result = bannerAdsRepository.findById(2L);

        assertTrue(result.isDeleted());
    }
}