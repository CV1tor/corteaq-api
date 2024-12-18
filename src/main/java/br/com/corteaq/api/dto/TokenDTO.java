package br.com.corteaq.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TokenDTO(@NotNull @NotBlank String token) {
}
