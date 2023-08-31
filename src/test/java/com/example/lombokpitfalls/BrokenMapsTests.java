package com.example.lombokpitfalls;

import com.example.lombokpitfalls.entities.Comment;
import com.example.lombokpitfalls.entities.Post;
import com.example.lombokpitfalls.entities.User;
import com.example.lombokpitfalls.repositories.UserRepository;
import com.example.lombokpitfalls.repositories.CommentRepository;
import com.example.lombokpitfalls.repositories.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class BrokenMapsTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void userSetTest() {
        User user = new User();
        Set<User> set = new HashSet<>();

        set.add(user);
        userRepository.save(user);

        Assertions.assertTrue(set.contains(user));
    }

    @Test
    void postSetTest() {
        Post post = new Post();
        Set<Post> set = new HashSet<>();

        set.add(post);
        postRepository.save(post);

        Assertions.assertTrue(set.contains(post));
    }

    @Test
    void commentSetTest() {
        Comment comment = new Comment();
        Set<Comment> set = new HashSet<>();

        set.add(comment);
        commentRepository.save(comment);

        Assertions.assertTrue(set.contains(comment));
    }
}
