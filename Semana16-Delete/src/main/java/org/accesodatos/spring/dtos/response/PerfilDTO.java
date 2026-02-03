package org.accesodatos.spring.dtos.response;

import lombok.Data;

@Data
public class PerfilDTO {
    private Long id;
    private String nombreCompleto;
    private String telefono;
    private String direccion;
}
