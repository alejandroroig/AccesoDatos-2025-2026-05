package org.accesodatos.spring.services;

import org.accesodatos.spring.dtos.request.create.UsuarioCreateDTO;
import org.accesodatos.spring.dtos.request.update.UsuarioUpdateDTO;
import org.accesodatos.spring.dtos.response.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> obtenerTodosLosUsuarios();
    UsuarioDTO obtenerUsuarioPorId(Long id);
    UsuarioDTO crearUsuario(UsuarioCreateDTO dto);
    UsuarioDTO actualizarUsuario(Long id, UsuarioUpdateDTO dto);
    void eliminarUsuario(Long id);
}
