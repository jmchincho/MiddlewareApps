package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Administrator;
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
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorRepositoryTestIT {

    @Autowired
    public AdministratorRepository administratorRepository;

    @Mock
    private Administrator administrator;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllAdministratorByUser() throws Exception {
        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Administrator.class.getSimpleName());

        List<Administrator> result = administratorRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(administrator -> administrator.getName().equals("nameAdmin1")));
        //assertTrue(result.stream().anyMatch(administrator -> administrator.getUser().getUsername().equals("admin1")));
    }

    @Test
    public void countAllShouldReturn2() {
        assertTrue(administratorRepository.countAll() != 0L);
    }

    @Test
    public void getShouldReturnAdministratorById2() throws Exception {
        Administrator administrator2 = administratorRepository.findById(2L);

        assertTrue(administrator2.getName().equals("nameAdmin2"));
        assertTrue(administrator2.getId().equals(2L));
    }

    @Test
    public void createAllShouldInsertNewAdministrator() throws Exception {
        when(administrator.getName()).thenReturn("Jose Manuel");
        when(administrator.getSurname()).thenReturn("Chincho");

        administratorRepository.insert(administrator);

        Long result = administratorRepository.countAll();

        assertTrue(result.equals(3L));
    }

    @Test
    public void updateAllShouldUpdateAdministratorById3L() throws Exception {
        Administrator administratorUpdate = administratorRepository.findById(2L);
        administratorUpdate.setSurname("Chincho Cardosa");

        administratorRepository.update(administratorUpdate);

        Administrator updateAdministrator = administratorRepository.findById(2L);

        assertTrue(updateAdministrator.getName().equals("nameAdmin2"));
        assertTrue(updateAdministrator.getSurname().equals("Chincho Cardosa"));
    }

    @Test
    public void deleteShouldRemoveAdministratorById() throws Exception {
        administratorRepository.delete(2L);

        Administrator administratorDelete = administratorRepository.findById(2L);

        assertTrue(administratorDelete.getUser().isDeleted());
    }
}