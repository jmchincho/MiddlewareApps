package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Category;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryRepositoryTestIT {

    @Autowired
    public CategoryRepository categoryRepository;

    @Mock
    private Category category;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllCategoryByUser() throws Exception {
        Page<Category> result = categoryRepository.findAll(null);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(category -> category.getName().equals("Deportes")));
    }

    @Test
    public void findShouldReturnCategoryByFilterCategory() throws Exception {
        when(category.getName()).thenReturn("Deportes");

        Page<Category> result = categoryRepository.findAll(category);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(category -> category.getName().equals("Deportes")));
    }

    @Test
    public void getShouldReturnCategoryById1() throws Exception {
        Category result = categoryRepository.findById(1L);

        assertNotNull(result);
        assertEquals(result.getName(), "Alimentación");
    }

    @Test
    public void createAllShouldInsertNewCategory() throws Exception {
        when(category.getName()).thenReturn("Muebles");
        when(category.getState()).thenReturn("enabled");
        when(category.getSequence()).thenReturn(3);

        categoryRepository.insert(category);

        Category result = categoryRepository.findById(3L);

        assertNotNull(result);
        assertEquals(result.getName(), "Muebles");
        assertEquals(result.getState(), "enabled");
        assertThat(result.getSequence(), equalTo(3));

    }

    @Test
    public void updateAllShouldUpdateCategoryById() throws Exception {
        Category update = categoryRepository.findById(3L);
        update.setName("Muebles2");

        categoryRepository.update(update);

        Category result = categoryRepository.findById(3L);

        assertNotNull(result);
        assertEquals(result.getName(), "Muebles2");
        assertEquals(result.getState(), "enabled");
        assertThat(result.getSequence(), equalTo(3));
    }

    @Test
    public void deleteShouldRemoveCategoryById() throws Exception {
        categoryRepository.delete(2L);

        Category result = categoryRepository.findById(2L);

        assertTrue(result.isDeleted());
    }
}