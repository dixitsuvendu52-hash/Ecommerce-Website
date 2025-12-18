package com.example.demo.controller;



import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "${cors.allowed.origins:http://localhost:4200}")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Register new user (role default: USER)
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User created = userService.register(user);
        return ResponseEntity.ok(created);
    }

    // Simple login -> returns user info on success, 401 on failure
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User login) {
        User u = userService.login(login.getUsername(), login.getPassword());
        if (u == null) return ResponseEntity.status(401).body("Invalid credentials");
        return ResponseEntity.ok(u);
    }
}

