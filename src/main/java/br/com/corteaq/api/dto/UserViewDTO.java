package br.com.corteaq.api.dto;

import br.com.corteaq.api.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserViewDTO(@NotNull UUID id, @NotNull @NotBlank String username, @NotNull @NotBlank String firstName,
                          @NotNull @NotBlank String lastName, @NotNull @NotBlank String telephoneNumber,
                          @NotNull UserType userType) {
}
