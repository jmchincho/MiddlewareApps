package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
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
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Offer.class.getSimpleName());

        List<Offer> result = offerRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(address -> address.getPrice().equals(10.00)));
        assertTrue(result.stream().anyMatch(address -> address.getItem().getId().equals(item.getId())));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = offerRepository.count();

        assertNotNull(result);
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