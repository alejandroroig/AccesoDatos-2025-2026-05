package org.accesodatos.spring.repositories;

import org.accesodatos.spring.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
