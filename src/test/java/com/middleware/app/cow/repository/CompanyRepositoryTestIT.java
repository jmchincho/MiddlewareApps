package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Company;
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
public class CompanyRepositoryTestIT {

    @Autowired
    public CompanyRepository companyRepository;

    @Mock
    private Company company;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllCompanyByUser() throws Exception {
        String where = "a.user.id=1";
        String orderBy = "a.street asc";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Company.class.getSimpleName());

        List<Company> result = companyRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(company -> company.getName().equals("nameCompany1")));
        //assertTrue(result.stream().anyMatch(company -> company.getUser().getUsername().equals("company1")));
    }

    @Test
    public void countAllShouldReturn2() {
        assertTrue(companyRepository.countAll() != 0L);
    }

    @Test
    public void getShouldReturnCompanyById1() throws Exception {
        Company company2 = companyRepository.findById(2L);

        assertTrue(company2.getName().equals("nameCompany2"));
        assertTrue(company2.getId().equals(2L));
    }

    @Test
    public void createAllShouldInsertNewCompany() throws Exception {
        when(company.getName()).thenReturn("Jose Manuel");
        when(company.getLogo()).thenReturn("logo");
        when(company.getCif()).thenReturn("47390823A");
        when(company.getUrl()).thenReturn("url");
        when(company.getUrlState()).thenReturn("urlState");

        companyRepository.insert(company);

        Long result = companyRepository.countAll();

        assertTrue(result.equals(3L));
    }

    @Test
    public void updateAllShouldUpdateCompanyById() throws Exception {
        Company companyUpdate = companyRepository.findById(2L);
        companyUpdate.setCif("47390823A");

        companyRepository.update(companyUpdate);

        Company updateCompany = companyRepository.findById(2L);

        assertTrue(updateCompany.getName().equals("nameCompany2"));
        assertTrue(updateCompany.getCif().equals("47390823A"));
    }

    @Test
    public void deleteShouldRemoveCompanyById() throws Exception {
        companyRepository.delete(2L);

        Company companyDelete = companyRepository.findById(2L);

        assertTrue(companyDelete.getUser().isDeleted());
    }
}