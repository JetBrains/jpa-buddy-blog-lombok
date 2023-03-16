package com.example.lombokpitfalls.repositories;

import com.example.lombokpitfalls.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}