package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/") 
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	  private  UserService userService;
	/* private final UserService userService; */

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public User register(@RequestBody User user) {
    	System.out.println("register");
    	user.setId(null);
        return userService.register(user);
    }

    @PostMapping("login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @GetMapping("")
    public List<User> getAll() {
        return userService.findAll();
    }
    

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteById(id);
//        return "User Deleted Successfully";
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }
}
