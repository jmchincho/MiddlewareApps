package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.Select;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressRepositoryTestIT {

    @Autowired
    public AddressRepository addressRepository;

    @Mock
    private Address address;

    @Mock
    private User user;

    @Mock
    private Location location;

    @Before
    public void setUp() throws Exception {
        when(user.getId()).thenReturn(1L);

        when(location.getId()).thenReturn(1L);

        when(address.getUser()).thenReturn(user);
    }

    @Test
    public void findShouldReturnAllAddressesByUser() throws Exception {
        String where = "address.user_id=1";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Address.class.getSimpleName());

        List<Address> result = addressRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(4));
        assertTrue(result.stream().anyMatch(address -> address.getUser().getId().equals(user.getId())));
    }

    @Test
    public void getShouldReturnAddressById1() throws Exception {
        Address result = addressRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getStreet().equals("Calle Jerico"));
        assertTrue(result.getId().equals(1L));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = addressRepository.count();

        assertNotNull(result);
    }

    @Test
    public void createAllShouldInsertNewAddress() throws Exception {
        when(address.getStreet()).thenReturn("Calle Belianes");
        when(address.getNumber()).thenReturn(30);
        when(address.getPostalCode()).thenReturn(28043);
        when(address.getFloor()).thenReturn(10);
        when(address.getStairs()).thenReturn(1);
        when(address.getLocation()).thenReturn(location);

        Long id = addressRepository.insert(address);

        Address addressInsert = addressRepository.findById(4L);

        assertTrue(addressInsert.getStreet().equals("Calle Belianes"));
        assertTrue(addressInsert.getNumber().equals(30));
        assertTrue(addressInsert.getPostalCode().equals(28043));
        assertTrue(addressInsert.getFloor().equals(10));
        assertTrue(addressInsert.getStairs().equals(1));
        assertTrue(addressInsert.getId().equals(4L));
        assertTrue(addressInsert.getUser().getId().equals(1L));
    }

    @Test
    public void updateAllShouldUpdateAddressById2() throws Exception {
        Address update = addressRepository.findById(2L);
        update.setNumber(31);
        update.setPostalCode(28044);

        addressRepository.update(update);

        Address addressUpdate = addressRepository.findById(2L);

        assertTrue(addressUpdate.getNumber().equals(31));
        assertTrue(addressUpdate.getPostalCode().equals(28044));
    }

    @Test
    public void deleteShouldRemoveAddressById4() throws Exception {
        addressRepository.delete(1L);

        Address addressDelete = addressRepository.findById(1L);

        assertTrue(addressDelete.isDeleted());
    }
}