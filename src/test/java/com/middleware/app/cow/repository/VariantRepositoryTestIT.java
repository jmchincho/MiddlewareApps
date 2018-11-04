package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Variant;
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
public class VariantRepositoryTestIT {

    @Autowired
    public VariantRepository variantRepository;

    @Mock
    private Variant variant;

    @Mock
    private Item item;

    @Before
    public void setUp() throws Exception {
        when(item.getId()).thenReturn(1L);
    }

    @Test
    public void findShouldReturnAllVariantByUser() throws Exception {
        Page<Variant> result = variantRepository.findAll(variant);

        assertThat(result.size(), equalTo(2));
        assertTrue(result.getResult().stream().anyMatch(variant -> variant.getPrice().equals(9.00)));
        assertTrue(result.getResult().stream().anyMatch(variant -> variant.getItem().getId().equals(item.getId())));
    }

    @Test
    public void findShouldReturnVariantByFilterVariantAndUser() throws Exception {
        when(variant.getItem()).thenReturn(item);

        Page<Variant> result = variantRepository.findAll(variant);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(variant -> variant.getPrice().equals(10.00)));
        assertTrue(result.getResult().stream().anyMatch(variant -> variant.getItem().getId().equals(item.getId())));
    }

    @Test
    public void getShouldReturnVariantById1() throws Exception {
        Variant result = variantRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(10.00));
        assertTrue(result.getItem().getId().equals(item.getId()));
        assertTrue(result.getId().equals(1L));
    }

    @Test
    public void createAllShouldInsertNewVariant() throws Exception {
        when(variant.getItem()).thenReturn(item);
        when(variant.getType()).thenReturn("type");
        when(variant.getSize()).thenReturn("size");
        when(variant.getColor()).thenReturn("color");
        when(variant.getFinishDate()).thenReturn(new Date());
        when(variant.getStartDate()).thenReturn(new Date());
        when(variant.getPublishDate()).thenReturn(new Date());
        when(variant.getState()).thenReturn("enabled");
        when(variant.getStock()).thenReturn(6);
        when(variant.getPrice()).thenReturn(9.99);

        variantRepository.insert(variant);

        Variant result = variantRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(9.99));
        assertTrue(result.getItem().getId().equals(item.getId()));
        assertTrue(result.getId().equals(3L));
        assertTrue(result.getStock().equals(6));
    }

    @Test
    public void updateAllShouldUpdateVariantById() throws Exception {
        Variant update = variantRepository.findById(3L);
        update.setStock(4);

        variantRepository.update(update);

        Variant result = variantRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getPrice().equals(9.99));
        assertTrue(result.getItem().getId().equals(item.getId()));
        assertTrue(result.getId().equals(3L));
        assertTrue(result.getStock().equals(4));
    }

    @Test
    public void deleteShouldRemoveVariantById() throws Exception {
        variantRepository.delete(1L);

        Variant variantDelete = variantRepository.findById(1L);

        assertTrue(variantDelete.isDeleted());
    }
}