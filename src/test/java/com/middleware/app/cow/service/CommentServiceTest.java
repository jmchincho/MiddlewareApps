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

	private CommentService commentService;

	@Mock
	private CommentRepository commentRepository;

	@Mock
	private List<Comment> comments;

	@Mock
	private Comment comment;

	@Mock
	private Page<Comment> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(comments);

		when(commentRepository.findAll(any())).thenReturn(page);

		when(commentRepository.findById(anyLong())).thenReturn(comment);

		commentService = new CommentServiceImpl(commentRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Comment> result = commentService.find(1,1, any(Comment.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(commentRepository.findAll(any())).thenThrow(new Exception());

		commentService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Comment result = commentService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(commentRepository.findAll(any())).thenThrow(new Exception());

		commentService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		commentService.create(comment);

		verify(commentRepository, times(1)).insert(comment);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(commentRepository).insert(any());

		commentService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		commentService.update(comment);

		verify(commentRepository, times(1)).update(comment);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(commentRepository).update(any());

		commentService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		commentService.delete(1L);

		verify(commentRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(commentRepository).delete(any());

		commentService.delete(any());
	}

}