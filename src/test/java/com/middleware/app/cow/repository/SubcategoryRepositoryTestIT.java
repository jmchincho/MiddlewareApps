package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.domain.Subcategory;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.JVM)
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
        Page<Subcategory> result = subcategoryRepository.findAll(null);

        assertThat(result.size(), equalTo(2));
        assertTrue(result.getResult().stream().anyMatch(subcategory -> subcategory.getName().equals("Futbol")));
    }

    @Test
    public void findShouldReturnSubcategoryByFilterSubcategoryAndUser() throws Exception {
        when(subcategory.getState()).thenReturn("disabled");

        Page<Subcategory> result = subcategoryRepository.findAll(subcategory);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(subcategory -> subcategory.getName().equals("Padel")));
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