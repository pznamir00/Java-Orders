package com.application.orders.documents;

import com.application.orders.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order extends BaseDocument {
    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("status")
    private OrderStatus status;

    @Field("archived")
    private boolean archived;
}
