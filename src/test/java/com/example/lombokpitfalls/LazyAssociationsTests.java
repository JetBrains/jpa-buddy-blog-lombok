package com.example.lombokpitfalls;

import com.example.lombokpitfalls.entities.User;
import com.example.lombokpitfalls.repositories.UserRepository;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class LazyAssociationsTests {
 @Autowired
 private UserRepository userRepository;
 
 private final PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();
 
 @Test
 @Sql(scripts = "classpath:com/example/lombokpitfalls/insert-user-with-posts.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
 @Sql(scripts = "classpath:com/example/lombokpitfalls/delete-user-with-posts.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
 public void toStringLazyTest() {
 User user = userRepository.findById(0L).orElseThrow();
 Assertions.assertFalse(persistenceUnitUtil.isLoaded(user.getPosts()));
 String s = user.toString();
 Assertions.assertFalse(persistenceUnitUtil.isLoaded(user.getPosts()));
 }
 
 @Test
 @Sql(scripts = "classpath:com/example/lombokpitfalls/insert-user-with-comments.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
 @Sql(scripts = "classpath:com/example/lombokpitfalls/delete-user-with-comments.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
 public void toStringExcludeLazyTest() {
 User user = userRepository.findById(0L).orElseThrow();
 Assertions.assertFalse(persistenceUnitUtil.isLoaded(user.getComments()));
 String s = user.toString();
 Assertions.assertFalse(persistenceUnitUtil.isLoaded(user.getComments()));
 }
}