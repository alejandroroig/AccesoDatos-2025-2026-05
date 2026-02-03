package org.accesodatos.spring.dtos.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PerfilUpdateDTO {
    @NotBlank
    @Size(max = 100)
    private String nombreCompleto;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "[0-9]+", message = "El teléfono solo puede contener números (sin espacios ni otros carácteres)")
    private String telefono;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 50, message = "La dirección no puede superar los 50 caracteres")
    private String direccion;
}
