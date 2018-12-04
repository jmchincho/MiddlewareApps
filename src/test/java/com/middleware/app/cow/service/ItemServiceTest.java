package com.middleware.app.cow.service;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.ItemRepository;
import com.middleware.app.cow.service.impl.ItemServiceImpl;
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
public class ItemServiceTest {

	private ItemService itemService;

	@Mock
	private ItemRepository itemRepository;

	@Mock
	private List<Item> items;

	@Mock
	private Item item;

	@Before
	public void setUp() throws Exception {
		when(itemRepository.findAll(any(), any(), any(), any())).thenReturn(items);

		when(itemRepository.findById(anyLong())).thenReturn(item);

		itemService = new ItemServiceImpl(itemRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		List<Item> result = itemService.find(anyInt(), anyInt(), anyString(), anyString());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(itemRepository.findAll(any(), any(), any(), any())).thenThrow(new Exception());

		itemService.find(anyInt(), anyInt(), anyString(), anyString());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Item result = itemService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(itemRepository.findById(any())).thenThrow(new Exception());

		itemService.get(any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		itemService.create(item);

		verify(itemRepository, times(1)).insert(item);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(itemRepository).insert(any());

		itemService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		itemService.update(item);

		verify(itemRepository, times(1)).update(item);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(itemRepository).update(any());

		itemService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		itemService.delete(1L);

		verify(itemRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(itemRepository).delete(any());

		itemService.delete(any());
	}

}