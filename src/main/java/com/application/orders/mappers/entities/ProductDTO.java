package com.application.orders.mappers.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record ProductDTO(
        @NotNull @Size(max = 32) String name,
        @NotNull @NotEmpty @URL String url,
        @NotNull @Positive int price
){}
