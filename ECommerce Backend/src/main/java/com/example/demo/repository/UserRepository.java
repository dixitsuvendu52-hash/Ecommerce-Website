package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailAndPassword(String email, String password);
	User findByUsername(String username);
   // User findByEmail(String email);
	 User findByEmail(String email);
}