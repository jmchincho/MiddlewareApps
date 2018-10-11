package com.middleware.app.cow.web;

import com.middleware.app.cow.CowApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class CompaniesEndpointTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindAll() {
    }

    @Test
    public void testFindAllByFilter() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testPost() {
    }

    @Test
    public void testPut() {
    }

    @Test
    public void testDelete() {
    }

}