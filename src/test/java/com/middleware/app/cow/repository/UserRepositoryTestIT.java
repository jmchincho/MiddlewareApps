package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.User;
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
public class UserRepositoryTestIT {

    @Autowired
    public UserRepository userRepository;

    @Mock
    private User user;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllUserByUser() throws Exception {
        Page<User> result = userRepository.findAll(null);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(user -> user.getUsername().equals("jmchincho")));
    }

    @Test
    public void findShouldReturnUserByFilterUserAndUser() throws Exception {
        when(user.getUsername()).thenReturn("jmchincho");

        Page<User> result = userRepository.findAll(user);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(user -> user.getUsername().equals("jmchincho")));
    }

    @Test
    public void getShouldReturnUserById1() throws Exception {
        User result = userRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getUsername().equals("jmchincho"));
        assertTrue(result.getId().equals(1L));
    }

    @Test
    public void createAllShouldInsertNewUser() throws Exception {
        when(user.getUsername()).thenReturn("josemanuel.chincho");
        when(user.getPassword()).thenReturn("password");
        when(user.getMail()).thenReturn("josemanuel.chincho@capitanoferta.com");
        when(user.getState()).thenReturn("activo");

        userRepository.insert(user);

        User userInsert = userRepository.findById(4L);

        assertTrue(userInsert.getUsername().equals("josemanuel.chincho"));
        assertTrue(userInsert.getPassword().equals("password"));
        assertTrue(userInsert.getMail().equals("josemanuel.chincho@capitanoferta.com"));
        assertTrue(userInsert.getState().equals("activo"));
    }

    @Test
    public void updateAllShouldUpdateUserById() throws Exception {
        User update = userRepository.findById(1L);
        update.setUsername("cambiado");

        userRepository.update(update);

        User userUpdate = userRepository.findById(1L);

        assertTrue(userUpdate.getUsername().equals("cambiado"));
    }

    @Test
    public void deleteShouldRemoveUserById() throws Exception {
        userRepository.delete(1L);

        User userDelete = userRepository.findById(1L);

        assertTrue(userDelete.isDeleted());
    }
}