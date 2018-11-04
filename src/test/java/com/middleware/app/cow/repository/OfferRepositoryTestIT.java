package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Offer;
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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.JVM)
public class OfferRepositoryTestIT {

    @Autowired
    public OfferRepository offerRepository;

    @Mock
    private Offer offer;

    @Mock
    private Item item;

    @Before
    public void setUp() throws Exception {
        when(item.getId()).thenReturn(1L);
    }

    @Test
    public void findShouldReturnAllOfferByUser() throws Exception {
        Page<Offer> result = offerRepository.findAll(offer);

        assertThat(result.size(), equalTo(2));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getPrice().equals(10.00)));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getItem().getId().equals(item.getId())));
    }

    @Test
    public void findShouldReturnOfferByFilterOfferAndUser() throws Exception {
        when(offer.getItem()).thenReturn(item);

        Page<Offer> result = offerRepository.findAll(offer);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getPrice().equals(130.00)));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getItem().getId().equals(item.getId())));
    }

    @Test
    public void getShouldReturnOfferById1() throws Exception {
        Offer result = offerRepository.findById(2L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(10.00));
        assertTrue(result.getState().equals("enabled"));
        assertTrue(!result.getItem().getId().equals(item.getId()));
    }

    @Test
    public void createAllShouldInsertNewOffer() throws Exception {
        when(offer.getState()).thenReturn("enabled");
        when(offer.getStartDate()).thenReturn(new Date());
        when(offer.getPublishDate()).thenReturn(new Date());
        when(offer.getFinishDate()).thenReturn(new Date());
        when(offer.getPaymentType()).thenReturn("PaymentType");
        when(offer.getPrice()).thenReturn(30.50);
        when(offer.getItem()).thenReturn(item);

        offerRepository.insert(offer);

        Offer result = offerRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(30.50));
        assertTrue(result.getState().equals("enabled"));
        assertTrue(result.getPaymentType().equals("PaymentType"));
        assertTrue(result.getItem().getId().equals(item.getId()));
    }

    @Test
    public void updateAllShouldUpdateOfferById() throws Exception {
        Offer update = offerRepository.findById(3L);
        update.setPrice(40.79);

        offerRepository.update(update);

        Offer result = offerRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(40.79));
        assertTrue(result.getState().equals("enabled"));
        assertTrue(result.getPaymentType().equals("PaymentType"));
        assertTrue(result.getItem().getId().equals(item.getId()));
    }

    @Test
    public void deleteShouldRemoveOfferById() throws Exception {
        offerRepository.delete(3L);

        Offer offerDelete = offerRepository.findById(3L);

        assertTrue(offerDelete.isDeleted());
    }
}