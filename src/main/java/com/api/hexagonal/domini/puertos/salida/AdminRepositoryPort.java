package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.infraestructura.entity.UsuarioAdminEntity;
import java.util.Optional;
import java.util.List;

public interface AdminRepositoryPort {
    UsuarioAdminEntity save(UsuarioAdminEntity admin);

    Optional<UsuarioAdminEntity> findById(Integer id);

    Optional<UsuarioAdminEntity> findByEmail(String email);

    void deleteById(Integer id);

    List<UsuarioAdminEntity> findAll();
}
