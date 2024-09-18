package edu.tcu.cs.hogwartsartifactsonline.hogwartsuser.dto;

import jakarta.validation.constraints.NotEmpty;

// Not a good idea to send password to the client side
public record UserDto(Integer id,
                      @NotEmpty(message = "username is required.")
                      String username,
                      boolean enabled,
                      @NotEmpty(message = "roles are required.")
                      String roles) {
}
