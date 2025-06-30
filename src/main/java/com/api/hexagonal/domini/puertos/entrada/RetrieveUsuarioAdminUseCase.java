package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import java.util.List;
import java.util.Optional;

public interface RetrieveUsuarioAdminUseCase {
    Optional<UsuarioAdmin> getUsuarioAdminById(Integer id);

    List<UsuarioAdmin> getAllUsuariosAdmin();

    Optional<UsuarioAdmin> getUsuarioAdminByEmail(String email);
}
