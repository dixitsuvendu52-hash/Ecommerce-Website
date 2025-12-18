package com.example.demo.service;

import com.example.demo.model.Order;
import java.util.List;

public interface OrderService {
    Order placeOrder(Order order);
    List<Order> getByUserId(Long userId);
    List<Order> getAll();
}
