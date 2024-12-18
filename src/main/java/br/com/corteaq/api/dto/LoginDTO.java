package br.com.corteaq.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDTO(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
}
