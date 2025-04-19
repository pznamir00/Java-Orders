package com.application.orders.documents;

import com.application.orders.enums.OrderStatus;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EntityListeners;

@Data
@EqualsAndHashCode(callSuper = true)
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
