package org.accesodatos.spring.dtos.request.create;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PerfilCreateDTO {
    @NotBlank(message = "El nombre completo no puede estar vacío")
    @Size(max = 100, message = "El nombre completo no puede superar los 100 caracteres")
    private String nombreCompleto;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "[0-9]+", message = "El teléfono solo puede contener números (sin espacios ni otros carácteres)")
    private String telefono;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 50, message = "La dirección no puede superar los 50 caracteres")
    private String direccion;
}
