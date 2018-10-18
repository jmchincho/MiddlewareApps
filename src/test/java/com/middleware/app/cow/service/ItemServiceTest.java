package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
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

	private ItemService ItemService;

	@Mock
	private ItemRepository ItemRepository;

	@Mock
	private List<Item> items;

	@Mock
	private Item item;

	@Mock
	private Page<Item> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(items);

		when(ItemRepository.findAll(any())).thenReturn(page);

		when(ItemRepository.findById(anyLong())).thenReturn(item);

		ItemService = new ItemServiceImpl(ItemRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Item> result = ItemService.find(1,1, any(Item.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(ItemRepository.findAll(any())).thenThrow(new Exception());

		ItemService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Item result = ItemService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(ItemRepository.findAll(any())).thenThrow(new Exception());

		ItemService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		ItemService.create(item);

		verify(ItemRepository, times(1)).insert(item);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(ItemRepository).insert(any());

		ItemService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		ItemService.update(item);

		verify(ItemRepository, times(1)).update(item);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(ItemRepository).update(any());

		ItemService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		ItemService.delete(1L);

		verify(ItemRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(ItemRepository).delete(any());

		ItemService.delete(any());
	}

}