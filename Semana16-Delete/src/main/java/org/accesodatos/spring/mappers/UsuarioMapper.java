package org.accesodatos.spring.mappers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.accesodatos.spring.dtos.request.create.PerfilCreateDTO;
import org.accesodatos.spring.dtos.request.create.UsuarioCreateDTO;
import org.accesodatos.spring.dtos.request.update.UsuarioUpdateDTO;
import org.accesodatos.spring.dtos.response.UsuarioDTO;
import org.accesodatos.spring.models.Cuenta;
import org.accesodatos.spring.models.Perfil;
import org.accesodatos.spring.models.Usuario;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class UsuarioMapper {

    private final PerfilMapper perfilMapper;

    public UsuarioDTO toDto(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setFechaRegistro(usuario.getFechaRegistro());
        dto.setPerfil(perfilMapper.toDto(usuario.getPerfil()));

        if (usuario.getCuentas() != null) {
            dto.setCuentas(usuario.getCuentas().stream().map(Cuenta::getId).toList());
        } else {
            dto.setCuentas(null);
        }

        return dto;
    }

    public Usuario toEntity(UsuarioCreateDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEmail(dto.getEmail());

        Perfil perfil = perfilMapper.toEntity(dto.getPerfil());
        usuario.setPerfil(perfil);

        return usuario;
    }

    public void updateUsuarioFromDto(UsuarioUpdateDTO dto, Usuario usuario) {
        if (dto == null || usuario == null) return;

        // Actualizamos campos y perfil
        usuario.setPassword(dto.getPassword());
        usuario.setEmail(dto.getEmail());
        perfilMapper.updatePerfilFromDto(dto.getPerfil(), usuario.getPerfil());
    }
}
