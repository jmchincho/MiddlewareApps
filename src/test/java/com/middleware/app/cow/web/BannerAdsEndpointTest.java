package com.middleware.app.cow.web;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.BannerAds;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.BannerAdsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class BannerAdsEndpointTest {

    @Mock
    private BannerAdsService bannerAdsService;

    private BannerAdsEndpoint bannerAdsEndpoint;

    @Mock
    private List<BannerAds> bannersAds;

    @Mock
    private BannerAds bannerAds;

    @Before
    public void setUp() throws Exception {
        when(bannerAdsService.find(anyInt(), anyInt(), anyString(), anyString())).thenReturn(bannersAds);

        when(bannerAdsService.countAll()).thenReturn(2L);

        when(bannerAdsService.get(any())).thenReturn(bannerAds);

        bannerAdsEndpoint = new BannerAdsEndpoint(bannerAdsService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = bannerAdsEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(bannerAdsService.find(anyInt(), anyInt(), anyString(), anyString())).thenThrow(new CowException());

        Response result = bannerAdsEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnResult() {
        Response result = bannerAdsEndpoint.countAll();

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnException() throws CowException {
        when(bannerAdsService.countAll()).thenThrow(new CowException());

        Response result = bannerAdsEndpoint.countAll();
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = bannerAdsEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(bannerAdsService.get(any())).thenThrow(new CowException());

        Response result = bannerAdsEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = bannerAdsEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(bannerAdsService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(bannerAdsService).create(any());

        Response result = bannerAdsEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = bannerAdsEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(bannerAdsService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(bannerAdsService).update(any());

        Response result = bannerAdsEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = bannerAdsEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(bannerAdsService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(bannerAdsService).delete(any());

        Response result = bannerAdsEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}