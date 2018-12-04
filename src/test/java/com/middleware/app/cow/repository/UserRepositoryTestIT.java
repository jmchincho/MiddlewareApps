package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.User;
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
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(User.class.getSimpleName());

        List<User> result = userRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(5));
        assertTrue(result.stream().anyMatch(user -> user.getUsername().equals("admin1")));
    }

    @Test
    public void findByUsernameShouldReturnUser() throws Exception {
        String username = "admin1";

        User result = userRepository.findByUsername(username);

        assertNotNull(result);
        assertTrue(result.getUsername().equals("admin1"));
    }

    @Test
    public void findByUsernameShouldReturnNull() throws Exception {
        String username = "aaaaaa";

        User result = userRepository.findByUsername(username);

        assertNull(result);
    }

    @Test
    public void getShouldReturnUserById1() throws Exception {
        User result = userRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getUsername().equals("admin1"));
        assertTrue(result.getId().equals(1L));
    }

    @Test
    public void createAllShouldInsertNewUser() throws Exception {
        when(user.getUsername()).thenReturn("josemanuel.chincho");
        when(user.getPassword()).thenReturn("password");
        when(user.getMail()).thenReturn("josemanuel.chincho@capitanoferta.com");
        when(user.getState()).thenReturn("activo");

        userRepository.insert(user);

        User userInsert = userRepository.findById(7L);

        assertTrue(userInsert.getUsername().equals("josemanuel.chincho"));
        assertTrue(userInsert.getPassword().equals("password"));
        assertTrue(userInsert.getMail().equals("josemanuel.chincho@capitanoferta.com"));
        assertTrue(userInsert.getState().equals("activo"));
    }

    @Test
    public void updateAllShouldUpdateUserById() throws Exception {
        User update = userRepository.findById(7L);
        update.setUsername("cambiado");

        userRepository.update(update);

        User userUpdate = userRepository.findById(7L);

        assertTrue(userUpdate.getUsername().equals("cambiado"));
    }

    @Test
    public void deleteShouldRemoveUserById() throws Exception {
        userRepository.delete(7L);

        User userDelete = userRepository.findById(7L);

        assertTrue(userDelete.isDeleted());
    }
}