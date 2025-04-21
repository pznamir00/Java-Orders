package com.application.orders.documents;

import com.application.orders.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EntityListeners;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
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

    @Field("products")
    private List<Product> products;

    @JsonProperty
    public double getTotalCost() {
        return products != null
                ? products
                    .stream()
                    .mapToDouble(Product::getPrice)
                    .reduce(0, Double::sum)
                : 0;
    }
}
