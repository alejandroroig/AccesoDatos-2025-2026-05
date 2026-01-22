package org.accesodatos.spring.repositories;

import org.accesodatos.spring.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
