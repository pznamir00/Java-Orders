package com.application.orders.repositories;

import com.application.orders.documents.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>, BaseOrderRepository {
}
