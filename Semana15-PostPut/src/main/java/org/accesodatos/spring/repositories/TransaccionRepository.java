package org.accesodatos.spring.repositories;

import org.accesodatos.spring.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
