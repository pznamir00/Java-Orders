package com.application.orders.mappers.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrderCreationDTO(
    @Size(max = 20) @NotBlank @NotNull String title,
    @Size(max = 250) @NotBlank @NotNull String description,
    @NotNull boolean archived
) {
}
