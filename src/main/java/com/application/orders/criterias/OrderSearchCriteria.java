package com.application.orders.criterias;

import com.application.orders.enums.OrderStatus;
import lombok.Builder;

@Builder
public record OrderSearchCriteria(
        String query,
        Boolean archived,
        OrderStatus status
) {
}
