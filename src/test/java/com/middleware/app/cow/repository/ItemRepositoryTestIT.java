package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Subcategory;
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
public class ItemRepositoryTestIT {

    @Autowired
    public ItemRepository itemRepository;

    @Mock
    private Item item;

    @Mock
    private Company company;

    @Mock
    private Subcategory subcategory;

    @Before
    public void setUp() throws Exception {
        when(company.getId()).thenReturn(1L);

        when(subcategory.getId()).thenReturn(2L);
    }

    @Test
    public void findShouldReturnAllItem() throws Exception {
        String where = "a.user.id=1";
        String orderBy = "a.street asc";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Item.class.getSimpleName());

        List<Item> result = itemRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(item -> item.getCompany().getId().equals(company.getId())));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = itemRepository.count();

        assertNotNull(result);
    }

    @Test
    public void getShouldReturnItemById1() throws Exception {
        Item result = itemRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getCompany().getId().equals(company.getId()));
        assertTrue(result.getDescriptions().equals("descriptions1"));
        assertTrue(result.getId().equals(1L));
    }

    @Test
    public void createAllShouldInsertNewItem() throws Exception {
        Date now = new Date();
        when(company.getId()).thenReturn(2L);

        when(item.getName()).thenReturn("item3");
        when(item.getDescriptions()).thenReturn("des3");
        when(item.getConditions()).thenReturn("con3");
        when(item.getCompany()).thenReturn(company);
        when(item.getSubcategory()).thenReturn(subcategory);
        when(item.getSendType()).thenReturn("sendType");
        when(item.getSendPrice()).thenReturn(0.0);
        when(item.getPrice()).thenReturn(20.0);
        when(item.getState()).thenReturn("enabled");
        when(item.getType()).thenReturn("type");
        when(item.getStock()).thenReturn(5);
        when(item.getStartDate()).thenReturn(now);
        when(item.getFinishDate()).thenReturn(now);
        when(item.getPublishDate()).thenReturn(now);

        itemRepository.insert(item);

        Item result = itemRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getCompany().getId().equals(company.getId()));
        assertTrue(result.getSendPrice().equals(0.0));
        assertTrue(result.getId().equals(3L));
        assertTrue(result.getName().equals("item3"));
        assertTrue(result.getDescriptions().equals("des3"));
        assertTrue(result.getConditions().equals("con3"));
        assertTrue(result.getSubcategory().getId().equals(subcategory.getId()));
        assertTrue(result.getSendType().equals("sendType"));
        assertTrue(result.getPrice().equals(20.0));
        assertTrue(result.getState().equals("enabled"));
        assertTrue(result.getType().equals("type"));
        assertTrue(result.getStock().equals(5));
    }

    @Test
    public void updateAllShouldUpdateItemById3() throws Exception {
        when(company.getId()).thenReturn(2L);

        Item update = itemRepository.findById(3L);
        update.setName("it3");
        update.setDescriptions("d3");

        itemRepository.update(update);

        Item result = itemRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getCompany().getId().equals(company.getId()));
        assertTrue(result.getSendPrice().equals(0.0));
        assertTrue(result.getId().equals(3L));
        assertTrue(result.getName().equals("it3"));
        assertTrue(result.getDescriptions().equals("d3"));
        assertTrue(result.getConditions().equals("con3"));
        assertTrue(result.getSubcategory().getId().equals(subcategory.getId()));
        assertTrue(result.getSendType().equals("sendType"));
        assertTrue(result.getPrice().equals(20.0));
        assertTrue(result.getState().equals("enabled"));
        assertTrue(result.getType().equals("type"));
        assertTrue(result.getStock().equals(5));
    }

    @Test
    public void deleteShouldRemoveItemById3() throws Exception {
        itemRepository.delete(3L);

        Item itemDelete = itemRepository.findById(3L);

        assertTrue(itemDelete.isDeleted());
    }
}