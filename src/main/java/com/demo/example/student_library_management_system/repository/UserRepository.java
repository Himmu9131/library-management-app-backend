package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {
   Optional<User> findByUsername(String username);
}
