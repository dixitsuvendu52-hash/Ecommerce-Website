package com.example.demo.service;



import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    User findById(Long id);
    List<User> findAll();
    User updateUser(Long id, User user);

    void deleteById(Long id);
}


