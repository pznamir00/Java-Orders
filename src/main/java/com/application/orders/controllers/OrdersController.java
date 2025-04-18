package com.application.orders.controllers;

import com.application.orders.documents.Order;
import com.application.orders.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
