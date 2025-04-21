package com.application.orders.mappers.entities;

import com.application.orders.enums.OrderStatus;
import java.time.Instant;
import java.util.List;

public record OrderDTO(
    String id,
    String title,
    String description,
    OrderStatus status,
    boolean archived,
    Instant createdAt,
    Instant updatedAt,
    List<ProductDTO> products
) {
}
