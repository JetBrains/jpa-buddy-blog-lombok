package com.example.lombokpitfalls;

import com.example.lombokpitfalls.entities.Comment;
import com.example.lombokpitfalls.entities.Post;
import com.example.lombokpitfalls.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class SameRecordTests {
    @PersistenceContext
    private EntityManager em;

    @Test
    void userDetachTest() {
        User user = new User();
        em.persist(user);

        User firstFetched = em.find(User.class, user.getId());
        em.detach(firstFetched);

        User secondFetched = em.find(User.class, user.getId());

        Assertions.assertEquals(firstFetched, secondFetched);
    }

    @Test
    void postDetachTest() {
        Post post = new Post();
        em.persist(post);

        Post firstFetched = em.find(Post.class, post.getId());
        em.detach(firstFetched);

        Post secondFetched = em.find(Post.class, post.getId());

        Assertions.assertEquals(firstFetched, secondFetched);
    }

    @Test
    void commentDetachTest() {
        Comment comment = new Comment();
        em.persist(comment);

        Comment firstFetched = em.find(Comment.class, comment.getId());
        em.detach(firstFetched);

        Comment secondFetched = em.find(Comment.class, comment.getId());

        Assertions.assertEquals(firstFetched, secondFetched);
    }
}
