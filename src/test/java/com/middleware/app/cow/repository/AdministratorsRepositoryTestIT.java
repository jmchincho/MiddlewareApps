package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class AdministratorRepositoryTestIT {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindAll() {
    }

    @Test
    public void testFindById() {
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testtestUpdate() {
    }

    @Test
    public void testtestDelete() {
    }

}