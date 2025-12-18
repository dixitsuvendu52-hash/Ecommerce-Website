package com.example.demo.controller;



import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.Order;
//import com.example.demo.service.AdminService; // below note: implement AdminService or reuse repo calls
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "${cors.allowed.origins:http://localhost:4200}")
public class AdminController {

    private final com.example.demo.service.UserService userService;
    private final com.example.demo.service.ProductService productService;
    private final com.example.demo.service.OrderService orderService;

    public AdminController(com.example.demo.service.UserService userService,
                           com.example.demo.service.ProductService productService,
                           com.example.demo.service.OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> allOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        Product created = productService.save(p);
        return ResponseEntity.ok(created);
    }
}

