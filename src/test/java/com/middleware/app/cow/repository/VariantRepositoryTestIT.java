package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Variant;
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
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Variant.class.getSimpleName());

        List<Variant> result = variantRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(variant -> variant.getPrice().equals(9.00)));
        assertTrue(result.stream().anyMatch(variant -> variant.getItem().getId().equals(item.getId())));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = variantRepository.count();

        assertNotNull(result);
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