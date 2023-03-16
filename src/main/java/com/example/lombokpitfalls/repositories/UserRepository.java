package com.example.lombokpitfalls.repositories;

import com.example.lombokpitfalls.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}