package br.com.corteaq.api.dto;

import br.com.corteaq.api.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull @NotBlank String username, @NotNull @NotBlank String password,
                          String telephoneNumber, @NotNull @NotBlank String firstName,
                          @NotNull @NotBlank String lastName,
                          @NotNull UserType userType) {
}
