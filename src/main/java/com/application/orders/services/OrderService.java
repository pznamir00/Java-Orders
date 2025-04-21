package com.application.orders.services;

import com.application.orders.criterias.OrderSearchCriteria;
import com.application.orders.documents.Order;
import com.application.orders.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAllByCriteria(OrderSearchCriteria criteria) {
        return orderRepository.findAllByCriteria(criteria);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(String id, Order orderData) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setTitle(orderData.getTitle());
        order.setDescription(orderData.getDescription());
        order.setArchived(orderData.isArchived());
        order.setProducts(orderData.getProducts());
        return orderRepository.save(order);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
