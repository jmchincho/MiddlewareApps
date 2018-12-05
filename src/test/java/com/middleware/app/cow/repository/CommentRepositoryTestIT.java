package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.Item;
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
public class CommentRepositoryTestIT {

    @Autowired
    public CommentRepository commentRepository;

    @Mock
    private Comment comment;

    @Mock
    private Item item;

    @Mock
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        when(item.getId()).thenReturn(1L);

        when(customer.getId()).thenReturn(1L);
    }

    @Test
    public void findShouldReturnAllComment() throws Exception {
        String where = "a.user.id=1";
        String orderBy = "a.street asc";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Comment.class.getSimpleName());

        List<Comment> result = commentRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(comment -> comment.getName().equals("name1")));
        assertTrue(result.stream().anyMatch(comment -> comment.getItem().getId().equals(item.getId())));
        assertTrue(result.stream().anyMatch(comment -> comment.getCustomer().getId().equals(customer.getId())));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = commentRepository.count();

        assertNotNull(result);
    }

    @Test
    public void getShouldReturnCommentById1() throws Exception {
        Comment result = commentRepository.findById(2L);

        assertNotNull(result);
        assertTrue(result.getName().equals("name2"));
        assertTrue(!result.getItem().getId().equals(1L));
        assertTrue(result.getCustomer().getId().equals(1L));
        assertTrue(result.getDescription().equals("description2"));
        assertTrue(result.getApproved().equals("approved"));
        assertTrue(result.getDenounced().equals("denounced"));
        assertTrue(result.getScore().equals(3));
    }

    @Test
    public void createAllShouldInsertNewComment() throws Exception {
        when(comment.getItem()).thenReturn(item);
        when(comment.getCustomer()).thenReturn(customer);
        when(comment.getName()).thenReturn("name3");
        when(comment.getDescription()).thenReturn("description3");
        when(comment.getScore()).thenReturn(4);

        commentRepository.insert(comment);

        Comment result = commentRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getName().equals("name3"));
        assertTrue(result.getItem().getId().equals(1L));
        assertTrue(result.getCustomer().getId().equals(1L));
        assertTrue(result.getDescription().equals("description3"));
        assertTrue(result.getApproved().equals("noapproved"));
        assertTrue(result.getScore().equals(4));
        assertTrue(result.getId().equals(3L));
    }

    @Test
    public void updateAllShouldUpdateCommentById() throws Exception {
        Comment update = commentRepository.findById(3L);
        update.setApproved("approved");

        commentRepository.update(update);

        Comment result = commentRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getName().equals("name3"));
        assertTrue(result.getItem().getId().equals(1L));
        assertTrue(result.getCustomer().getId().equals(1L));
        assertTrue(result.getDescription().equals("description3"));
        assertTrue(result.getApproved().equals("approved"));
        assertTrue(result.getScore().equals(4));
        assertTrue(result.getId().equals(3L));
    }

    @Test
    public void deleteShouldRemoveCommentById() throws Exception {
        commentRepository.delete(3L);

        Comment commentDelete = commentRepository.findById(3L);

        assertTrue(commentDelete.isDeleted());
    }
}