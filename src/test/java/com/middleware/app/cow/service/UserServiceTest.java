package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.UserRepository;
import com.middleware.app.cow.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class UserServiceTest {

	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private List<User> users;

	@Mock
	private User user;

	@Mock
	private Page<User> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(users);

		when(userRepository.findAll(any())).thenReturn(page);

		when(userRepository.findById(anyLong())).thenReturn(user);

		userService = new UserServiceImpl(userRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<User> result = userService.find(1,1, any(User.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(userRepository.findAll(any())).thenThrow(new Exception());

		userService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		User result = userService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(userRepository.findAll(any())).thenThrow(new Exception());

		userService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		userService.create(user);

		verify(userRepository, times(1)).insert(user);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(userRepository).insert(any());

		userService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		userService.update(user);

		verify(userRepository, times(1)).update(user);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(userRepository).update(any());

		userService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		userService.delete(1L);

		verify(userRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(userRepository).delete(any());

		userService.delete(any());
	}

}