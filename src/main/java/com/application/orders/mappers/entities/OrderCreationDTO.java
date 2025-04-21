package com.application.orders.mappers.entities;

import com.application.orders.documents.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record OrderCreationDTO(
        @Size(max = 20) @NotBlank @NotNull String title,
        @Size(max = 250) @NotBlank @NotNull String description,
        @NotNull boolean archived,
        @Valid @NotEmpty @NotNull List<ProductDTO> products
        ) {
}
