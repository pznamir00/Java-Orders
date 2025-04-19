package com.application.orders.controllers;

import com.application.orders.documents.Order;
import com.application.orders.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrdersList() {
        final List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        final Order createdOrder = orderService.create(order);
        return ResponseEntity.status(201).body(createdOrder);
    }
}
