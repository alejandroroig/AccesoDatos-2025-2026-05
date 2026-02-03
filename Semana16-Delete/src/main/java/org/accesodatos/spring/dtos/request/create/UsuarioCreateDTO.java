package org.accesodatos.spring.dtos.request.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
public class UsuarioCreateDTO {
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(max = 50, message = "El nombre de usuario no puede superar los 50 caracteres")
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 50, message = "La contraseña debe tener entre 8 y 50 caracteres")
    private String password;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El formato del email es inválido")
    private String email;

    @Valid
    @NotNull(message = "El perfil es obligatorio.")
    private PerfilCreateDTO perfil;
}
