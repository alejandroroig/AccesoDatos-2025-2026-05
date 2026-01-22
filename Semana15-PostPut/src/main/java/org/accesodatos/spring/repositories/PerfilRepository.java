package org.accesodatos.spring.repositories;

import org.accesodatos.spring.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    List<Perfil> findByNombreCompletoContainingIgnoreCase(String nombre);

    Optional<Perfil> findByUsuarioId(Long usuarioId);
}
