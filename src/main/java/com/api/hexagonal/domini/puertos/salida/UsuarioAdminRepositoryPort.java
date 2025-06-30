package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import java.util.Optional;
import java.util.List;

public interface UsuarioAdminRepositoryPort {
    UsuarioAdmin save(UsuarioAdmin usuarioAdmin);

    Optional<UsuarioAdmin> findById(Integer id);

    Optional<UsuarioAdmin> findByEmail(String email);

    List<UsuarioAdmin> findAll();

    boolean deleteById(Integer id);

    boolean existsByEmail(String email);
}
