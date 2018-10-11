package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.CowApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.render.TableAliasCalculator;
import org.mybatis.dynamic.sql.where.render.WhereClauseProvider;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class AddressRepositoryTestIT {

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