package com.application.orders.repositories;

import com.application.orders.criterias.OrderSearchCriteria;
import com.application.orders.documents.Order;
import java.util.List;

public interface BaseOrderRepository {
    public List<Order> findAllByCriteria(OrderSearchCriteria criteria);
}
