package org.accesodatos.spring.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.accesodatos.spring.dtos.request.create.UsuarioCreateDTO;
import org.accesodatos.spring.dtos.request.update.UsuarioUpdateDTO;
import org.accesodatos.spring.dtos.response.UsuarioDTO;
import org.accesodatos.spring.mappers.UsuarioMapper;
import org.accesodatos.spring.models.Perfil;
import org.accesodatos.spring.models.Usuario;
import org.accesodatos.spring.repositories.UsuarioRepository;
import org.accesodatos.spring.services.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .toList();
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario con id " + id + " no encontrado"));
        return usuarioMapper.toDto(usuario);
    }


    @Override
    @Transactional
    public UsuarioDTO crearUsuario(UsuarioCreateDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);

        // Persistimos el usuario (automáticamente persistirá el perfil debido a la cascada)
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }

    @Override
    @Transactional
    public UsuarioDTO actualizarUsuario(Long id, UsuarioUpdateDTO dto) {
        // 1. Buscar el usuario real en la BBDD por Id
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        // 2. Actualizar los campos, no crear un usuario nuevo
        usuarioMapper.updateUsuarioFromDto(dto, usuarioExistente);

        // 3. Guardar el usuario que ya tiene su estado original preservado
        return usuarioMapper.toDto(usuarioRepository.save(usuarioExistente));
    }
}
