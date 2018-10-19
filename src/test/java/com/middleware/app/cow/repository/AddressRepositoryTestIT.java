package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class AddressRepositoryTestIT {

    @Autowired
    private AddressRepository addressRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Address address;

    @Mock
    private User user;

    @Before
    public void setUp() throws Exception {
        when(user.getId()).thenReturn(1L);

        when(userRepository.findById(any())).thenReturn(user);

        when(address.getUser()).thenReturn(user);
    }

    @Test
    public void findShouldReturnAllAddressesByUser() throws Exception {
        Page<Address> result = addressRepository.findAll(address);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getUser().getId().equals(user.getId())));
    }

    @Test
    public void findShouldReturnAddressByFilterAddressAndUser() throws Exception {
        when(address.getStreet()).thenReturn("Calle Jerico");

        Page<Address> result = addressRepository.findAll(address);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getUser().getId().equals(user.getId())));
        assertTrue(result.getResult().stream().anyMatch(address -> address.getStreet().equals("Calle Jerico")));
    }

    /*@Test(expected = Exception.class)
    public void findShouldReturnException() throws Exception {

    }*/

    @Test
    public void getShouldReturnAddressById1() throws Exception {
        Address result = addressRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getStreet().equals("Calle Jerico"));
        assertTrue(result.getId().equals(1L));
    }

    /*@Test(expected = Exception.class)
    public void getShouldReturnException() throws Exception {

    }*/

    @Test
    public void createAllShouldReturnAddressInsert() throws Exception {
        when(address.getStreet()).thenReturn("Calle Belianes");
        when(address.getNumber()).thenReturn(30);
        when(address.getPostalCode()).thenReturn(28043);
        when(address.getFloor()).thenReturn(10);
        when(address.getStairs()).thenReturn(1);
        when(address.getUser().getId()).thenReturn(1L);

        addressRepository.insert(address);

        Address addressInsert = addressRepository.findById(4L);

        assertTrue(addressInsert.getStreet().equals("Calle Belianes"));
        assertTrue(addressInsert.getNumber().equals(30));
        assertTrue(addressInsert.getPostalCode().equals(28043));
        assertTrue(addressInsert.getFloor().equals(10));
        assertTrue(addressInsert.getStairs().equals(1));
        assertTrue(addressInsert.getId().equals(4L));
        assertTrue(addressInsert.getUser().getId().equals(1L));
    }

    /*@Test(expected = Exception.class)
    public void createAllShouldReturnException() throws Exception {

    }*/

    @Test
    public void updateAllShouldReturnResult() throws Exception {
        Address update = addressRepository.findById(2L);
        update.setNumber(31);
        update.setPostalCode(28044);

        addressRepository.update(update);

        Address addressUpdate = addressRepository.findById(2L);

        assertTrue(addressUpdate.getNumber().equals(31));
        assertTrue(addressUpdate.getPostalCode().equals(28044));
    }

    /*@Test(expected = Exception.class)
    public void updateAllShouldReturnException() throws Exception {

    }*/

    @Test
    public void deleteShouldReturnResult() throws Exception {
        addressRepository.delete(4L);

        Address addressDelete = addressRepository.findById(4L);

        assertNull(addressDelete);
    }

    /*@Test(expected = Exception.class)
    public void deleteShouldReturnException() throws Exception {

    }*/

}