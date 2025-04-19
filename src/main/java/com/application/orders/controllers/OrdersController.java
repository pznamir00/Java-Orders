package com.application.orders.controllers;

import com.application.orders.documents.Order;
import com.application.orders.exceptions.NotFoundException;
import com.application.orders.mappers.OrderMapper;
import com.application.orders.mappers.OrderSimplifiedMapper;
import com.application.orders.mappers.entities.OrderDTO;
import com.application.orders.mappers.entities.OrderSimplifiedDTO;
import com.application.orders.services.OrderService;
import jakarta.validation.Valid;
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
    private OrderMapper orderMapper;
    private OrderSimplifiedMapper orderSimplifiedMapper;

    @GetMapping
    public ResponseEntity<List<OrderSimplifiedDTO>> getOrdersList() {
        final List<OrderSimplifiedDTO> orders = orderService.findAll().stream().map(orderSimplifiedMapper::orderToOrderDTO).toList();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable String id) {
        final Optional<Order> order = orderService.findById(id);
        return order
                .map(orderMapper::orderToOrderDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Order doesn't exist"));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        final Order order = orderService.createOrder(orderMapper.orderDTOToOrder(orderDTO));
        return ResponseEntity.status(201).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @Valid @RequestBody OrderDTO orderDTO) {
        final Order order = orderService.updateOrder(id, orderMapper.orderDTOToOrder(orderDTO));
        return ResponseEntity.status(201).body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
