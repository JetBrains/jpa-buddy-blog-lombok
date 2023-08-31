package com.example.lombokpitfalls;

import com.example.lombokpitfalls.entities.Post;
import com.example.lombokpitfalls.entities.User;
import com.example.lombokpitfalls.repositories.PostRepository;
import com.example.lombokpitfalls.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class NoArgsConstructorTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

//    @Test
//    public void builderTest() {
//        User user = User.builder().id(1L).build();
//        userRepository.save(user);
//    }

//    @Test
//    public void allArgsConstructorTest() {
//        Post post = new Post(1L);
//        postRepository.save(post);
//    }
}