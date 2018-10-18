package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CommentRepository;
import com.middleware.app.cow.service.impl.CommentServiceImpl;
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
public class CommentServiceTest {

	private CommentService CommentService;

	@Mock
	private CommentRepository CommentRepository;

	@Mock
	private List<Comment> comments;

	@Mock
	private Comment comment;

	@Mock
	private Page<Comment> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(comments);

		when(CommentRepository.findAll(any())).thenReturn(page);

		when(CommentRepository.findById(anyLong())).thenReturn(comment);

		CommentService = new CommentServiceImpl(CommentRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Comment> result = CommentService.find(1,1, any(Comment.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CommentRepository.findAll(any())).thenThrow(new Exception());

		CommentService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Comment result = CommentService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(CommentRepository.findAll(any())).thenThrow(new Exception());

		CommentService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CommentService.create(comment);

		verify(CommentRepository, times(1)).insert(comment);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CommentRepository).insert(any());

		CommentService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		CommentService.update(comment);

		verify(CommentRepository, times(1)).update(comment);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CommentRepository).update(any());

		CommentService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		CommentService.delete(1L);

		verify(CommentRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(CommentRepository).delete(any());

		CommentService.delete(any());
	}

}