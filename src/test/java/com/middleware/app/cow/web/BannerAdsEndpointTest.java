package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
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

    @Mock
    private Response response;

    @Mock
    private Page<BannerAds> page;

    private BannerAdsEndpoint bannerAdsEndpoint;

    @Mock
    private List<BannerAds> bannersAds;

    @Mock
    private BannerAds bannerAds;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(bannersAds);
        when(bannerAdsService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(bannerAdsService.get(any())).thenReturn(bannerAds);

        bannerAdsEndpoint = new BannerAdsEndpoint(bannerAdsService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = bannerAdsEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(bannerAdsService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = bannerAdsEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = bannerAdsEndpoint.findAllByFilter(1, 5, bannerAds);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(bannerAdsService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = bannerAdsEndpoint.findAllByFilter(1, 5, bannerAds);

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