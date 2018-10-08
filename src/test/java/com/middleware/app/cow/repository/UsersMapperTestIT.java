package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import( CowApplicationTests.class)
public class UsersMapperTestIT {


}