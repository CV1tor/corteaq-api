package br.com.corteaq.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BarberDTO(@NotNull @NotBlank String firstname, @NotNull @NotBlank String lastname,
                        @NotNull @NotBlank String telephoneNumber, String description, Double rating) {
}
