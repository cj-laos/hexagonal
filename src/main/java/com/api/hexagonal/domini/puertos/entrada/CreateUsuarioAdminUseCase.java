package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;

public interface CreateUsuarioAdminUseCase {
    UsuarioAdmin createUsuarioAdmin(UsuarioAdmin usuarioAdmin);
}