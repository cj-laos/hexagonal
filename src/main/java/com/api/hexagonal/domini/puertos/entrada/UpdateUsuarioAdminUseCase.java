package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import java.util.Optional;

public interface UpdateUsuarioAdminUseCase {
    Optional<UsuarioAdmin> updateUsuarioAdmin(Integer id, UsuarioAdmin usuarioAdmin);
}