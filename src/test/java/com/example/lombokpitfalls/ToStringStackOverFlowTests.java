package com.example.lombokpitfalls;

import com.example.lombokpitfalls.entities.User;
import com.example.lombokpitfalls.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ToStringStackOverFlowTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql(scripts = "classpath:com/example/lombokpitfalls/insert-user-with-posts.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:com/example/lombokpitfalls/delete-user-with-posts.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test() {
        User user = userRepository.findById(1L).orElseThrow();
        String s = user.toString();
    }
}