package com.application.orders.mappers.entities;

import com.application.orders.enums.OrderStatus;

public record OrderSimplifiedDTO(
   String id,
   String title,
   String description,
   OrderStatus status,
   boolean archived,
   double totalCost
) {
}
