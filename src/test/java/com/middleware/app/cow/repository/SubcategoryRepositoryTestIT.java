package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Category;
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

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubcategoryRepositoryTestIT {

    @Autowired
    public SubcategoryRepository subcategoryRepository;

    @Mock
    private Subcategory subcategory;

    @Mock
    private Category category;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllSubcategoryByUser() throws Exception {
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Subcategory.class.getSimpleName());

        List<Subcategory> result = subcategoryRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(subcategory -> subcategory.getName().equals("Futbol")));
    }

    @Test
    public void getShouldReturnSubcategoryById1() throws Exception {
        Subcategory result = subcategoryRepository.findById(1L);

        assertNotNull(result);
        assertEquals(result.getName(), "Futbol");
    }

    @Test
    public void createAllShouldInsertNewSubcategory() throws Exception {
        when(subcategory.getCategory()).thenReturn(category);
        when(subcategory.getCategory().getId()).thenReturn(2L);
        when(subcategory.getName()).thenReturn("Congelados");
        when(subcategory.getState()).thenReturn("enabled");
        when(subcategory.getSequence()).thenReturn(1);

        subcategoryRepository.insert(subcategory);

        Subcategory result = subcategoryRepository.findById(3L);

        assertNotNull(result);
        assertEquals(result.getName(), "Congelados");
        assertEquals(result.getState(), "enabled");
        assertThat(result.getSequence(), equalTo(1));
    }

    @Test
    public void updateAllShouldUpdateSubcategoryById() throws Exception {
        Subcategory update = subcategoryRepository.findById(3L);
        update.setName("Verduras");

        subcategoryRepository.update(update);

        Subcategory result = subcategoryRepository.findById(3L);

        assertNotNull(result);
        assertEquals(result.getName(), "Verduras");
        assertEquals(result.getState(), "enabled");
        assertThat(result.getSequence(), equalTo(1));
    }

    @Test
    public void deleteShouldRemoveSubcategoryById() throws Exception {
        subcategoryRepository.delete(2L);

        Subcategory result = subcategoryRepository.findById(2L);

        assertTrue(result.isDeleted());
    }
}